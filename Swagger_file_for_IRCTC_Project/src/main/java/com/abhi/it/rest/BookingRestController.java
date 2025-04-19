package com.abhi.it.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;
import com.abhi.it.service.BookingServiseImpl;

@RestController
public class BookingRestController {
	@Autowired
	BookingServiseImpl service;
	
	@PostMapping(value = "/book",
			consumes = {"application/json"},
			produces = {"application/json"}
			)
	public ResponseEntity<Ticket> bookTickets(@RequestBody Customer customer){
		Ticket t = service.bookTicket(customer);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/ticket/{ticketNumber}",
				produces = {"application/json"}
			)
	public Ticket getTickets(@PathVariable("ticketNumber") Integer ticketNum) {
		return service.getTicket(ticketNum);
	}
}
