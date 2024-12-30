package ru.itis.userservice.client;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.eventservice.proto.EventServiceGrpcGrpc;
import ru.kpfu.itis.eventservice.proto.UserRequest;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceClient {

//    @GrpcClient("eventservice")
    private final EventServiceGrpcGrpc.EventServiceGrpcBlockingStub eventService;


    public List<String> getEventsByUserId(int id) {
        return eventService.getEventsByUserId(UserRequest.newBuilder()
                .setId(id)
                .build()).getEventsList();
    }
}
