package com.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FinalProjectUserNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectUserNewsApplication.class, args);
	}

}
