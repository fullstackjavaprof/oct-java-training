package com.javafullstacktraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld2Controller {
     @RequestMapping("/hello")  
	public String showMessage() {
		return " Welcome to spring boot ";
		}
}
