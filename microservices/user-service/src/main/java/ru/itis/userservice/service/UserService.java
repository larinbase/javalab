package ru.itis.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.userservice.client.UserServiceClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserServiceClient userServiceClient;

    public List<String> getEventsByUserId(int id) {
        return userServiceClient.getEventsByUserId(id);
    }
}
