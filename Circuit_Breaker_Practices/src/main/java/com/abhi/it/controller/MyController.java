package com.abhi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.abhi.it.binding.InterestRate;
import com.abhi.it.service.MyService;

@RestController
public class MyController {

	@Autowired
	MyService service;
	
	@GetMapping("/loan")
	public ResponseEntity<InterestRate> loan(@RequestParam("type") String type){
		return ResponseEntity.ok().body(service.getRate(type));
		}
}
