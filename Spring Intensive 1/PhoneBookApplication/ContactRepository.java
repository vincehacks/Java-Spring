package com.di.phonebook.repository;

import java.util.Map;
import com.di.phonebook.domain.Contact;

public interface ContactRepository {
	Map<String, Contact> getAllContacts();
	
	Contact findContact(String id);
	
	void deleteContact(String id);
	
	Contact addContact(String id, String name, String phone);
	
	Contact updateContact(Contact c);
}