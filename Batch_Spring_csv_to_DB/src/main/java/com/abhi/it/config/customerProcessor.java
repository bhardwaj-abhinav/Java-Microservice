package com.abhi.it.config;

import org.springframework.batch.item.ItemProcessor;

import com.abhi.it.entity.Customer;

public class customerProcessor implements ItemProcessor<Customer, Customer>{

	public Customer process(Customer item) {
		//logic
		
		return item;
	}
}
