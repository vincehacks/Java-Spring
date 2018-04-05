package com.di.phonebook.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.di.phonebook.domain.Contact;

@Component
public class ContactTable implements ContactRepository {

	private static Map<String, Contact> contacts = new HashMap<String, Contact>();
	static {
		for(Contact x : new Contact[] {
				new Contact("1", "Fred Flinstone", "555-1212"),
				new Contact("2", "Rupi Patel", "555-4444"),
				new Contact("3", "Hayao Miyazaki", "606-0842")
		}) {
			contacts.put(x.getId(), x);
		}
	}
	public Map<String, Contact> getAllContacts() {
		return contacts;
	}

	public Contact findContact(String id) {
		return contacts.get(id);
	}

	public void deleteContact(String id) {
		contacts.remove(id);
	}

	public Contact addContact(String id, String name, String phone) {
		Contact c = new Contact(id, name, phone);
		contacts.put(id, c);
		return c;
	}

	public Contact updateContact(Contact c) {
		String id = c.getId();
		contacts.remove(id);
		contacts.put(id, c);
		return c;
	}
}