package com.abhi.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AsyncWebClientExampleApplication {
	
	static private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNumber}";
	
	public static void main(String[] args) {
		SpringApplication.run(AsyncWebClientExampleApplication.class, args);
		System.out.println("request started...........");
		WebClient client = WebClient.create();
		client.get()
		.uri(GET_TICKET_URL, 101)
		.retrieve()
		.bodyToMono(String.class)
		.subscribe(AsyncWebClientExampleApplication::handleResponse);
		System.out.println("request ended...........");
	}
	
	public static void handleResponse(String response) {
		System.out.println("response got...........");
	}

}
