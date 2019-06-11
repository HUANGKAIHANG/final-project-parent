package com.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FinalProjectUserRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectUserRegisterApplication.class, args);
	}

}
