package com.switfcart.productservice;

import com.switfcart.productservice.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ProductServiceApplication.class);
		SpringApplication.run(ProductServiceApplication.class, args);
		logger.info("Product Service Started..");
	}

}
