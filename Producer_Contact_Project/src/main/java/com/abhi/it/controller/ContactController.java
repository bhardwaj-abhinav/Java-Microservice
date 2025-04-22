package com.abhi.it.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.it.entity.Contact;
import com.abhi.it.service.ContactService;


@RestController
public class ContactController {

	@Autowired
	private ContactService service;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody Contact contact) {
		service.save(contact);
		return "Contact Saved";
	}
	
	@GetMapping("/contacts")
	public List<Contact> getContact() {
		List <Contact> contacts = service.findAll();
		return contacts;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable Integer id) {
		service.deleteById(id);;
		return "Contact deleted";
	}
	
	@PutMapping("/edit/{id}")
	public String editContact(@PathVariable Integer id, @RequestBody Contact contact) {
		Optional<Contact> op= service.findById(id);
		Contact c = op.get();
		c.setName(contact.getName());
		c.setPhoneNumber(contact.getPhoneNumber());
		service.save(c);
		return "Contact Saved";
	}
	
}
