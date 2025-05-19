package com.abhi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.Service.MyService;

@RestController
public class MyController {

	@Autowired
	MyService service;
	
	@GetMapping("/")
	public ResponseEntity<String> getGreets(){
		String msg = service.getGreet();
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
