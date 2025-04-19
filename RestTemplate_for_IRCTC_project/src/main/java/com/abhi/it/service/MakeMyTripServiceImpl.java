package com.abhi.it.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService{
	private String BOOK_TICKET_URL = "http://localhost:8080/book";
	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNumber}";
	
	@Override
	public Ticket bookTicket(Customer customer) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, customer, Ticket.class);
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber );
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

}
