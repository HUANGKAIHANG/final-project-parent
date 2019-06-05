package com.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HUANG Kaihang
 * @create 2019/6/5 18:03
 * @update 2019/6/5 18:03
 */

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class FinalProjectConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectConfigurationServerApplication.class, args);
	}

}
