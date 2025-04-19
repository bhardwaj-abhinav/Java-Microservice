package com.abhi.it.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;

@Service
public class BookingServiseImpl implements BookingService{

	Map<Integer, Ticket> map = new HashMap<Integer, Ticket>();
	Integer ticketNum = 101;
	
	@Override
	public Ticket bookTicket(Customer customer) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(customer, ticket);
		ticket.setTicketCost(565.00);
		ticket.setTicketNumber(ticketNum);
		ticket.setStatus("Confirm");
		
		map.put(ticketNum, ticket);
		System.out.println("Ticket created...");
		
		ticketNum++;
		
		return ticket;
		
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		// TODO Auto-generated method stub
		
		if(map.containsKey(ticketNumber)) {
			return map.get(ticketNumber);
		}
		return null;
	}

}
