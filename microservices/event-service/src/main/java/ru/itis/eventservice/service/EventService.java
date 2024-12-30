package ru.itis.eventservice.service;

import java.util.List;
import java.util.Map;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.kpfu.itis.eventservice.proto.EventServiceGrpcGrpc;
import ru.kpfu.itis.eventservice.proto.UserRequest;
import ru.kpfu.itis.eventservice.proto.UserResponse;

@GrpcService
public class EventService extends EventServiceGrpcGrpc.EventServiceGrpcImplBase {

    private final Map<Integer, List<String>> events = Map.of(
            1, List.of("event1", "event2"),
            2, List.of("event3", "event4")
    );

    @Override
    public void getEventsByUserId(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse response = UserResponse.newBuilder()
                .addAllEvents(events.get(request.getId()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
