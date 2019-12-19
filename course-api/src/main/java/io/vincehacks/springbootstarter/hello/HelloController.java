// Created by Vince Chang

package io.vincehacks.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// By default this handles GET requests
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

}
