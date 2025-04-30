package com.abhi.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	@GetMapping("/")
	public String hi() {
		return "hi everyone";
	}
}
