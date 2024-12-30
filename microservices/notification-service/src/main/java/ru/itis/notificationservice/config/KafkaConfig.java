package ru.itis.notificationservice.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class KafkaConfig {

    @Value("${kafka.topic}")
    public String notificationTopic;

    @Bean
    public NewTopic notificationTopic() {
        log.info("Creating topic: {}", notificationTopic);
        return new NewTopic(notificationTopic, 1, (short)1);
    }
}