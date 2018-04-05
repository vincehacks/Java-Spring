/* Created by Vince Chang */

package com.di.helloworld;

import org.springframework.beans.factory.annotation.Value;

// This is the Beans implementation, that will ALWAYS implement an interface!
public class HelloSpringBean implements HelloSpring {
	// By using value, whatever message.greeting (key) is in message.properties
	// file) file, will be the value of message.greeting
	@Value("${message.greeting}")
	String message;
	
	public void setMessage(String m){
		this.message = m;
	}
	
	public String getMessage() {
		return this.message;
	}
}