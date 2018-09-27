package com.lzj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication3 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication3.class, args);
	}

}
