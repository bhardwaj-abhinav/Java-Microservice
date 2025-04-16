package com.abhi.it.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.binding.User;

@RestController
public class Mycontroller {
	
	private Map<Integer, User> map = new HashMap<Integer, User>();
	
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody User user){
		System.out.println(user);
		map.put(user.getId(), user);
		String msg = "Data Saved....";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user")
	public User getData(@RequestParam("id") Integer id) {
		User user = map.get(id);
		System.out.println(user);
		return user;
	}
	
	@GetMapping("/data/{id}/user")
	public User getUserData(@PathVariable("id") Integer id) {
		User user = map.get(id);
		System.out.println(user);
		return user;
	}
}
