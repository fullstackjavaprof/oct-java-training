package com.javafullstacktraining.messaging.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination = "testqueue")
	public void consume(String message) {
		System.out.println("Received message: "+message);
	}
}
