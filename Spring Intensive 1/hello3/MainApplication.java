/******************************************************************************
Created by Vince Chang

Lab 3 – Using Property Files

In unit 2 we saw several different configuration items. We used a few of
them with our PhoneBook application but using property files isn’t
appropriate with that example. To get practice with them, we are going to
return to our HelloSpring application.

1. Make a copy of HelloSpring2 and call it HelloSpring3.
2. Modify this application to read a message from a properties file.
• The file should be called messages.properties
• The file has one key – messages.greeting. You may set its value as you
wish
3. Modify JavaConfig as appropriate to load the property file and perform
component scanning.
4. Modify HelloSpringBean so that it the message field will be able to be
set as part of the startup of the application.
5. Modify MainApplication to no longer call setMessage
6. Run the application.
******************************************************************************/

package com.di.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		
		// Passing in the JavaConfig.class file which is the entry point
		// ApplicationContext is the spring container!
		ApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// .getBean will look in the Spring Container which is appContext.
		// appContext has a copy of JavaConfig.class for my ("bean", of type HellowSpringBean.class)
		HelloSpring bean = appContext.getBean("bean",HelloSpringBean.class);
		System.out.println(bean.getMessage());
	}
}