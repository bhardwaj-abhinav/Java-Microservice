package com.abhi.it.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.abhi.it.response.ContactResponse;

import reactor.core.publisher.Flux;

@Service
public class ContactServiceImpl implements ContactService{
	
	private String SAVE_CONTACT = "http://localhost:8081/save";
	private String GET_CONTACT = "http://localhost:8081/contacts";
	private String DELETE_CONTACT = "http://localhost:8081/delete/{id}";
	private String EDIT_CONTACT = "http://localhost:8081/edit/{id}";
	private String ONE_CONTACT = "http://localhost:8081/contact/{id}";
	
	public String saveContact(ContactResponse contactResponse) {
		WebClient client = WebClient.create();
		String msg = client.post()
				.uri(SAVE_CONTACT)
				.bodyValue(contactResponse)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return msg;
	}

	public List<ContactResponse> getContacts(){
		// TODO Auto-generated method stub
		WebClient client = WebClient.create();
		 Flux<ContactResponse> contacts = client.get()
				.uri(GET_CONTACT)
				.retrieve()
				.bodyToFlux(ContactResponse.class);
		 List<ContactResponse> allContacts = contacts.collectList().block();
		return  allContacts;
	}

	public String deleteContact(Integer id) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create();
		
		String msg = client.delete()
				.uri(DELETE_CONTACT, id)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		
		return msg;
	}


	@Override
	public ContactResponse getOneContact(Integer id) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create();
		ContactResponse res = client.get()
				.uri(ONE_CONTACT , id)
				.retrieve()
				.bodyToMono(ContactResponse.class)
				.block();
		
		return res;
	}
		
}
