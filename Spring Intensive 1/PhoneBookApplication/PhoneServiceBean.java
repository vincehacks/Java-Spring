/******************************************************************************
Created by Vince Chang

This implementation of Bean will implement the PhoneService interface
I am implementing each method by calling the ContactRepository methods
******************************************************************************/

package com.di.phonebook.service;

import java.util.Map;
import com.di.phonebook.domain.Contact;
import com.di.phonebook.repository.ContactRepository;
import javax.annotation.PostConstruct;

public class PhoneServiceBean implements PhoneService {
	
	ContactRepository contactRepo;
	
	@PostConstruct
	public void xxx() {
		System.out.println("Hello World");
	}
	
	public PhoneServiceBean(ContactRepository cr){
		this.contactRepo = cr;
	}
	
	public Map<String, Contact> getAllContacts(){
		return contactRepo.getAllContacts();
	}
	
	public Contact findContact(String id) {
		return contactRepo.findContact(id);
	}
	
	public void deleteContact(String id) {
		contactRepo.deleteContact(id);
	}
	
	public Contact addContact(String id, String name, String phone) {
		return contactRepo.addContact(id, name, phone);
	}
	
	public Contact updateContact(Contact c) {
		return contactRepo.updateContact(c);
	}
}