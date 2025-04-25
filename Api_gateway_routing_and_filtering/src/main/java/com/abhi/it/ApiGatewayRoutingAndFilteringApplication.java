package com.abhi.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayRoutingAndFilteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayRoutingAndFilteringApplication.class, args);
	}

}
