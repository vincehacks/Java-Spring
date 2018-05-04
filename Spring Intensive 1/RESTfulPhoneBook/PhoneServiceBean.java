/* Created by Vince Chang */

package com.di.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.di.phonebook.domain.Contact;
import com.di.phonebook.repository.ContactRepository;

@Controller
public class PhoneServiceBean implements PhoneService {

  @Autowired // We annotated the class
  private ContactRepository repository;

  /*public void setContactRepository(ContactRepository contactRepository) {
    this.repository = contactRepository;
  }

  public ContactRepository getContactRepository() {
    return repository;
  }*/

  // Container makes the call to make the model
  @RequestMapping ("/contacts")
  public String getAllContacts(Model model) {
    model.addAllAttributes(repository.getAllContacts());
    // This is string that will go to the view resolver to find the file
    return "contactList";
  }

  public Contact findContact(String id) {
    return repository.findContact(id);
  }

  public void deleteContact(String id) {
    repository.deleteContact(id);
  }

  public Contact addContact(String id, String name, String phone) {
    return repository.addContact(id, name, phone);
  }

  public Contact updateContact(Contact c) {
    return repository.updateContact(c);
  }
}