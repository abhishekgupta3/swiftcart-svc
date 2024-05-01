package com.switfcart.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);
		SpringApplication.run(UserServiceApplication.class, args);
		logger.info("User Service Started..");
	}

}
