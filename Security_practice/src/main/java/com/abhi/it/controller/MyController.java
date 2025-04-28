package com.abhi.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/contact")
	public String contacts() {
		return "+91 987654324";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
