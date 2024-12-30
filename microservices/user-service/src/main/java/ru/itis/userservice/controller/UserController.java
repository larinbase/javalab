package ru.itis.userservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.userservice.client.UserServiceClient;
import ru.itis.userservice.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserServiceClient userServiceClient;

    @GetMapping("/{id}/events")
    public List<String> getEvents(@PathVariable("id") int id) {
        log.info("Getting events for user with id: {}", id);
//        return userService.getEventsByUserId(id);
        return userServiceClient.getEventsByUserId(id);
    }
}
