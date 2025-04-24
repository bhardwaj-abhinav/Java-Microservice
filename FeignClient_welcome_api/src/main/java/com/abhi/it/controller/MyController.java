package com.abhi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.feign.GreetFeignClient;

@RestController
public class MyController {
	
	@Autowired
	private GreetFeignClient client;

	@GetMapping("/welcome")
	public String welcome() {
		String response = client.invokeGreetApi();
		return response + " welcome";
	}
}
