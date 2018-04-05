/******************************************************************************
Created by Vince Chang

Lab 1 – Hello Spring #8-11!

For this lab, we will make a simple HelloWorld application, using Spring.
There will be three classes, the interface, the Spring bean and the
application class. We will do two versions of this. One using the
application-config.xml for configuration, the other using JavaConfig.

1. Define a new Maven project.
2. Fix the pom.xml file to use Spring
3. We will make 3 classes – the interface, the bean and the application in
the src/main/java directory.
• Suggested names are HelloSpring, HelloSpringBean and MainApplication
• The bean should have two methods – setMessage and getMessage
• MainApplicationshouldgetyourApplicationContext,callboth
methods, and print your message to the console
4. Define the application-config.xml for this project.
• Select our project and name the file application-config.xml
• Select Finish
5. Move the application-config.xml file to be under the src/main/java directory
6. Modify application-config.xml to wire your HelloSpringBean.
7. Run the application.

===> Start here for this lab!
8. Copy the HelloWorld project and name the new one HelloWorld2.
9. Define a JavaConfig file to wire your HelloSpringBean using Java.
10. Modify MainApplication to now use the JavaConfig file instead of
application-config.xml.
11. Run the application.
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
		// appContext has a copy of JavaConfig.class for my
		// ("bean", of type HellowSpringBean.class)
		HelloSpringBean bean = appContext.getBean("bean",HelloSpringBean.class);
		bean.setMessage("This is the message!!!");
		System.out.println(bean.getMessage());
	}
}