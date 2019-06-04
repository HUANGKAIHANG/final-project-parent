package com.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author HUANG Kaihang
 * @create 2019/6/4 21:06
 * @update 2019/6/4 21:06
 */

@SpringBootApplication
@EnableZuulProxy
public class FinalProjectGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectGatewayApplication.class, args);
	}

}
