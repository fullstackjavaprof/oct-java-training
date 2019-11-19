package com.testing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@RequestMapping("/hello")
	public String showMessage() {
		return "This is spring security applicaiton";
		
	}
}
