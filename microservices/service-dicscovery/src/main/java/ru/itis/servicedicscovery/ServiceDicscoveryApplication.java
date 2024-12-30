package ru.itis.servicedicscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class ServiceDicscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDicscoveryApplication.class, args);
	}

}
