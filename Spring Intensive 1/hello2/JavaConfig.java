/******************************************************************************
Created by Vince Chang

This is the configuration file that will annotate a bean.
******************************************************************************/
package com.di.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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