package com.abhi.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.abhi.it.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
