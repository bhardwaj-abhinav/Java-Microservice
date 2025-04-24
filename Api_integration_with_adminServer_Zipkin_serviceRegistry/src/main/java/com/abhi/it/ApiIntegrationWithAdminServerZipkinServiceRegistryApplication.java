package com.abhi.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiIntegrationWithAdminServerZipkinServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiIntegrationWithAdminServerZipkinServiceRegistryApplication.class, args);
	}

}
