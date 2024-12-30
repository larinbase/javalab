package ru.itis.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final List<String> notifications = new LinkedList<>();

    public List<String> getNotifications() {
        return notifications;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "notificationGroupId")
    public void listenNotifications(@Payload String message) {
        notifications.add(message);
    }
}
