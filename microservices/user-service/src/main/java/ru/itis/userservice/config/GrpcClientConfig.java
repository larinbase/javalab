package ru.itis.userservice.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.eventservice.proto.EventServiceGrpcGrpc;

@Configuration
public class GrpcClientConfig {

    @Value("${grpc.server.port}")
    private int port;

    @Bean
    public EventServiceGrpcGrpc.EventServiceGrpcBlockingStub eventServiceGrpcBlockingStub() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();

        return EventServiceGrpcGrpc.newBlockingStub(channel);
    }
}
