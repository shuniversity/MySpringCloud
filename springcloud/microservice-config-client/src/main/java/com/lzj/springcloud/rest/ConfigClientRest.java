package com.lzj.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${server.port}")
	private String serverPort;
	
	@RequestMapping("/config")
	public String getConfig(){
		String str = "application : " + applicationName;
		String port = "port : " + serverPort;
		System.out.println("applicationName : " + str);
		System.out.println(port);

		return str;
	}
}
