package com.di.phonebook.service;

import org.springframework.ui.Model;
import com.di.phonebook.domain.Contact;

public interface PhoneService {

/*  void setContactRepository(ContactRepository repository);

  ContactRepository getContactRepository();*/

  String getAllContacts(Model m);

  Contact findContact(String id);

  void deleteContact(String id);

  Contact addContact(String id, String name, String phone);

  Contact updateContact(Contact c);
}