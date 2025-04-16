package com.abhi.it.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class MyController {
	
	@PostMapping("/")
	public ResponseEntity<String> saveData() {
		//logic
		String msg = "Data saved....";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getData() {
		//logic
		String msg = "Data fetch....";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
