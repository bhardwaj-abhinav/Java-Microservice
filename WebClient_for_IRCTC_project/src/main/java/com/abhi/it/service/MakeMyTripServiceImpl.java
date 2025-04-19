package com.abhi.it.service;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService{
	private String BOOK_TICKET_URL = "http://localhost:8080/book";
	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNumber}";
	
	@Override
	public Ticket bookTicket(Customer customer) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create();
		Ticket ticket = client.post()
				.uri(BOOK_TICKET_URL)
				.bodyValue(customer)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
				
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create();
		Ticket ticket = client.get()
		.uri(GET_TICKET_URL, ticketNumber)
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		return ticket;
	}

}
