package com.abhi.it.service;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;

public interface MakeMyTripService {

	public Ticket bookTicket(Customer customer);
	public Ticket getTicket(Integer ticketNumber);
	
}
