package com.abhi.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.it.response.ContactResponse;
import com.abhi.it.service.ContactServiceImpl;

@Controller
public class ContactController {

	@Autowired
	private ContactServiceImpl service;
	
	@GetMapping("/")
	public String getForm(Model model) {
		model.addAttribute("contactResponse", new ContactResponse());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveContact(@ModelAttribute("contactResponse") ContactResponse contact, Model model) {
		String msg = service.saveContact(contact);
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping("/view-contacts")
	public String getContact(Model model) {
		
		model.addAttribute("contacts", service.getContacts());
		return "data";
	}
	
	@GetMapping("/delete")
	public String delteContact(@RequestParam("id") Integer id, Model model) {
		String msg = service.deleteContact(id);
		model.addAttribute("contacts", service.getContacts());
		model.addAttribute("msg" ,msg);
		return "data";
	}
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("id") Integer id, Model model) {
		ContactResponse contactResponse= service.getOneContact(id);
		model.addAttribute("contactResponse", contactResponse);
		return "index";
	}
	
}
