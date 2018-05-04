/******************************************************************************
Created by Vince Chang

This interface will have method declarations that will have to be
implemented in any class that implements this interface!
******************************************************************************/

package com.di.phonebook.service;

import java.util.Map;
import com.di.phonebook.domain.Contact;

public interface PhoneService {
  Map<String, Contact> getAllContacts();

  Contact findContact(String id);

  void deleteContact(String id);

  Contact addContact(String id, String name, String phone);

  Contact updateContact(Contact c);
}