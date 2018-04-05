/****************************************************************************** 
	Created by Vince Chang

  Lab 5 – WebMVC PhoneBook

  Now that we have a working PhoneBook application, let’s turn it into a web
  application. To do this, we will first start with importing a Maven project
  called RESTfulPhoneBook. This is the same PhoneBookApplication that we have
  been working on, it just has been reconfigured for a web application.

  1. Update the pom.xml file to add the following dependencies:
		  a. groupId: org.springframework
		  artifactId: spring-webmvc
		  version: 4.3.10.RELEASE

		  b. groupId: org.springframework
		  artifactId: spring-web
		  version: 4.3.10.RELEASE

		  c. groupId: javax.servlet
		  artifactId: jstl
		  version: 1.2

  2. Define a new class called MVCConfig that contains the necessary MVC
  configuration information
  3. Define a new class called WebAppInitializer and configure the
  DispatcherServlet
  4. Modify PhoneServiceBean. This class is our Controller
  a. Each method should be given an appropriate RequestMapping
  b. Modify the getAllContacts() method so that it can be used to get a JSP
  page that would then read the model (the contacts themselves) Note: You may
  want to modify the method declaration for this method. If so, don’t forget to
  modify the declaration in PhoneService. The JSP page that will allow you to
  show the all the contacts has already been developed for you. It is called
  contactList.jsp and can be found under WEB-INF/views.
 *****************************************************************************/

package com.di.phonebook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.di.phonebook")
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").
		addResourceLocations("/resources/"); 
	}
	
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	public InternalResourceViewResolver viewResolver() { 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setAlwaysInclude(true);
		return resolver;
	}
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.viewResolver(viewResolver());
	}
}