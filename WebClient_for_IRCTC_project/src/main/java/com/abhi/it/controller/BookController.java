package com.abhi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.it.Request.Customer;
import com.abhi.it.response.Ticket;
import com.abhi.it.service.MakeMyTripServiceImpl;

@Controller
public class BookController {

	@Autowired
	private MakeMyTripServiceImpl service;
	
	@GetMapping("/")
	public String getForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "index";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Customer customer, Model model) {
		Ticket t = service.bookTicket(customer);
		System.out.println(t);
		model.addAttribute("msg", "Ticket is booked with id " + t.getTicketNumber());
		return "index";
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-page";
	}
	
	@GetMapping("/view-ticket")
	public String searchTicket(@RequestParam Integer ticketNum, Model model) {
		Ticket t = service.getTicket(ticketNum);
		System.out.println(t);
		model.addAttribute("ticket", t);
		return "ticket-page";
	}
}
