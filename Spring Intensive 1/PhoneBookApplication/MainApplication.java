/******************************************************************************
Created by Vince Chang

Lab 2 – Initial Wiring of PhoneBookApplication

In this and many future labs, we are going to work on a PhoneBook application
You will be given the three base classes – Contact.java, ContactTable.java
and ContactRepository.java. The ContactTable will represent your contacts,
the ContactRepository will be the interface for this.

1. Import the initial project by going to File > Import > Maven then
selecting Existing Maven Projects. Select Next then find the
PhoneBookApplication which should be under your Resources directory. Select
Finish.
2. Define a new package called com.di.phonebook.service. In this package, we
will define two new classes – PhoneService and PhoneServiceBean.
• The interface should have the same methods in it that ContactRepository has
• The bean should have a constructor that takes the ContactRepository
as an argument
• Override the inherited methods to call their corresponding method in
ContactRepository
3. Write the JavaConfig file for this project and place it in a new
packagecalled com.di.phonebook.config.
4. Write the application class, named whatever you like.
5. Run the application.
******************************************************************************/

package com.di.phonebook.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.di.phonebook.config.JavaConfig;

public class MainApplication {

  public static void main(String[] args) {
    // Passing in the JavaConfig.class file which is the entry point
    // ApplicationContext is the container!
    ApplicationContext appContext =
    new AnnotationConfigApplicationContext(JavaConfig.class);

    /* .getBean will look in the Spring Container which is appContext.
     * appContext has a copy of JavaConfig.class for my
     * ("bean", of type PhoneServiceBean.class)
     * Return the type of interface, because multiple beans can implement the
     * same interface!
     */
    PhoneService bean = appContext.getBean("bean",PhoneServiceBean.class);

    // Prints out the information from the phone book!
    System.out.println(bean.getAllContacts());
  }
}