package com.microservices.ribbontime.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableDiscoveryClient
@SpringBootApplication
public class RibbonTimeServiceApplication {
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeServiceApplication.class, args);
	}

	@GetMapping
	public String getTime() {
		System.out.println(" The server port is " + port);

		return "The current time is " + new Date().toString() + " (answered by service running on " + port + ")";
	}
}
