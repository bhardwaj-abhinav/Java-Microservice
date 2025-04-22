package com.abhi.it.service;

import java.util.List;

import com.abhi.it.response.ContactResponse;

public interface ContactService {
	public String saveContact(ContactResponse contactResponse);
	
	public List<ContactResponse> getContacts();
	
	public String deleteContact(Integer id);
	
	public ContactResponse getOneContact(Integer id);
}
