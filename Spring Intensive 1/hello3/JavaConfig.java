/******************************************************************************
Created by Vince Chang

Now using @PropertySource and passing in the value from message.properties
******************************************************************************/

package com.di.helloworld;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"message.properties"}) // Setting the path to my message
public class JavaConfig {
	
	/* The return type is the interface !
	 * To give my bean an id, need to pass in like ("bean")
	 * This just returns the interface
	 */
	@Bean("bean")
	public HelloSpring HelloSpring() {
		return new HelloSpringBean();
	}
}
