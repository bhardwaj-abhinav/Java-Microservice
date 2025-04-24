package com.abhi.it.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greet")
	public String greet() {
		String port = env.getProperty("server.port");
		return "Good Morning! (" + port +" )";
	}
	
}
