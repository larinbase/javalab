package ru.itis.notificationservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    @Value("${kafka.topic}")
    public String notificationTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Sending message to topic {}: {}", notificationTopic, message);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(notificationTopic, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                Objects.requireNonNull(result);
                System.out.println(result.getProducerRecord().value() + "  " + result.getRecordMetadata().toString());
            } else {
                throw new IllegalArgumentException(ex);
            }
        });
    }

}
