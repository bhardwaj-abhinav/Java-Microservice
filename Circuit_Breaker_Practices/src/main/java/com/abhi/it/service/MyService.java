package com.abhi.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhi.it.binding.InterestRate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MyService {
	
	
	private RestTemplate rt = new RestTemplate();
	
	private static final String SERVICE_NAME = "loan-service";
	private static final String URI = "http://localhost:8081/";
	
	@CircuitBreaker(
			name = "SERVICE_NAME",
			fallbackMethod = "getDefaultRate"
			)
	public InterestRate getRate(String type) {
		System.out.println("*******original method***********");
		ResponseEntity<InterestRate> res = rt.getForEntity(URI, InterestRate.class, type);
		return res.getBody();
	}
	
	public InterestRate getDefaultRate(String type) {
		System.out.println("*******fallback method***********");
		return new InterestRate();
	}
}
