package ru.itis.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public void send(@RequestBody String message) {
        notificationService.send(message);
    }

}
