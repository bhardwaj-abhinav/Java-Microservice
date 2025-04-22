package com.abhi.it.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.it.entity.Contact;

public interface ContactService extends JpaRepository<Contact, Integer>{

}
