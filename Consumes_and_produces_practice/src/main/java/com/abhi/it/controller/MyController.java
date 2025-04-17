package com.abhi.it.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.abhi.it.binding.Book;

@RestController
public class MyController {

	@PostMapping(value="/save",
			consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		//logic
		return new ResponseEntity<String>("Data saved..", HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/book",
			produces = {"application/xml", "application/json" }
			)
	public Book getBook() {
			Book b = new Book();
			b.setAuthor("Abhinav");
			b.setId(101);
			b.setName("Sita");
			return b;
		}
	}

