package com.abhi.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.exception.UserNotFound;

@RestController
public class Mycontroller {

	@GetMapping("/")
	public String welcome() {
		int i =10/0;
		return "welcome";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable Integer id) throws Exception {
		if(id==100) {
			return "Abhinav";
		}
		else if (id==101) {
			return "Prachi";
		}
		else {
			throw new UserNotFound("User not found");
		}
	}
	
}
