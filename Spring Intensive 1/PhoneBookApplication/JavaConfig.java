/******************************************************************************
	Created by Vince Chang
	This is the configuration file that will have information about beans
******************************************************************************/

package com.di.phonebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.di.phonebook.repository.ContactRepository;
import com.di.phonebook.repository.ContactTable;
import com.di.phonebook.service.PhoneService;
import com.di.phonebook.service.PhoneServiceBean;

@Configuration
@ComponentScan // By having @ComponentScan, will look for all @Components
public class JavaConfig {

	// Return Type is always the interface and you return a
	// call to the implementation that returns you back of the type interface!
	
	// Created a new contactRepo bean that will reference the contact table
	@Bean("contactTable")
	public ContactRepository contactRepository() {
		return new ContactTable();
	}
	
	@Bean("bean")
	public PhoneService phoneService() {
		return new PhoneServiceBean(contactRepository());
	}
}