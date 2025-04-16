package com.abhi.it;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		//object to json
		Address address = new Address();
		address.setCity("Delhi");
		address.setHouseNo(165);
		
		Person p = new Person();
		p.setAddress(address);
		p.setAge(25);
		p.setEmail("a@gmail.com");
		p.setName("Abhi");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Person.json"), p);
		System.out.println("Json created.....");
		
		//json to object
		File f = new File("Person.json");		
		Person person = mapper.readValue(f, Person.class);
		System.out.println(person);
	}
}
