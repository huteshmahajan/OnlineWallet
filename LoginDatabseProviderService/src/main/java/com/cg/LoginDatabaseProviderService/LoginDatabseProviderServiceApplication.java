package com.cg.LoginDatabaseProviderService;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LoginDatabseProviderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginDatabseProviderServiceApplication.class, args);
	}

}
