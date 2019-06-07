package com.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author HUANG Kaihang
 * @create 2019/6/5 17:31
 * @update 2019/6/5 17:31
 */

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
public class FinalProjectAdminSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectAdminSessionApplication.class, args);
	}

}
