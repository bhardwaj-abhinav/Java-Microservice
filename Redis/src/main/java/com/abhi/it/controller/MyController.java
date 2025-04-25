package com.abhi.it.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.binding.Countries;

@RestController
public class MyController {
	
	private HashOperations<String, Integer, Countries> ops= null;
	
	public MyController(RedisTemplate<String, Countries> rt) {
		this.ops = rt.opsForHash();
	}
	
	@PostMapping("/countries")
	public String addCountry(@RequestBody Countries country) {
		ops.put("COUNTRIES", country.getSno(), country);
		return "country added";
	}
	
	@GetMapping("/country")
	public Collection<Countries> getCountries() {
		Map<Integer, Countries> country= ops.entries("COUNTRIES");
		Collection<Countries> collection = country.values();
		return collection;
	}
	
}
