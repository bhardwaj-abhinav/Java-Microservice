package com.abhi.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
	
	@GetMapping("/admin")
	public String admin() {
		return "<h3>Welcome admin </h3>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h3>Welcome user</h3>";
	}
	
	@GetMapping("/")
	public String welcome() {
		return "<h3>Welcome</h3>";
	}
	
}
