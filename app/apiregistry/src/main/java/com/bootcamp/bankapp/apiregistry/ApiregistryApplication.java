package com.bootcamp.bankapp.apiregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiregistryApplication.class, args);
	}

}
