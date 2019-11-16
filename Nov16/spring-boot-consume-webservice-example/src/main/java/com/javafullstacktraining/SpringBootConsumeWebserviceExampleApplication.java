package com.javafullstacktraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootConsumeWebserviceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsumeWebserviceExampleApplication.class, args);
	}
	
	   @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }


}
