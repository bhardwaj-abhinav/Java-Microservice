package com.abhi.it;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;



public class Main {

	public static void main(String[] args) throws IOException{
		//object to json
		Address address = new Address();
		address.setCity("Delhi");
		address.setHouseNo(165);
		
		Person p = new Person();
		p.setAddress(address);
		p.setAge(25);
		p.setEmail("a@gmail.com");
		p.setName("Abhi");
		
		//obj to json
		Gson gson = new Gson();
		String person = gson.toJson(p);
		System.out.println(person);
		System.out.println("Json created....");
		
		//json to obj
		Person p1 = gson.fromJson(person, Person.class);
		System.out.println(p1);
	}
}
