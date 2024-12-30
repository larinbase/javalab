package ru.itis.eventservice.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itis.eventservice.service.EventService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
@RequiredArgsConstructor
public class GrpcServer {

    private Server server;

    @Value("${grpc.server.port}")
    private Integer port;

//    private final EventService grpcService;

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new EventService())
                .build()
                .start();
        log.info("Server started on port: {}", port);
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.shutdown();
            System.out.println("gRPC Server stopped");
        }
    }
}