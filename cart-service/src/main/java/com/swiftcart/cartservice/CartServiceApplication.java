package com.swiftcart.cartservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class CartServiceApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(CartServiceApplication.class);
		SpringApplication.run(CartServiceApplication.class, args);
		logger.info("CART SERVICE START");
	}

}
