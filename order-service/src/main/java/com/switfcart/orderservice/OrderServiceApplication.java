package com.switfcart.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class OrderServiceApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);
		SpringApplication.run(OrderServiceApplication.class, args);
		logger.info("ORDER SERVICE STARTED");
	}

}
