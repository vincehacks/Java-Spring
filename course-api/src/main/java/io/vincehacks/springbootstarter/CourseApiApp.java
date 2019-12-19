// Created by Vince Chang

package io.vincehacks.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

  // This is the entry point of the application, this will automatically have a servlet container for my app
	// Sets up default configuration, starts Spring application context, performs class path scan, starts Tomcat server
	public static void main(String[] args) {
		// Tell Spring this is a spring application
		SpringApplication.run(CourseApiApp.class,args);
	}
}
