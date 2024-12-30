package ru.itis.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.userservice.service.NotificationService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-notification")
public class UserNotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<String> getNotifications() {
        return notificationService.getNotifications();
    }
}
