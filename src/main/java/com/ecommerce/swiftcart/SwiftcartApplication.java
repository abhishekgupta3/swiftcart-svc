package com.ecommerce.swiftcart;

import com.ecommerce.swiftcart.repository.ProductDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class SwiftcartApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SwiftcartApplication.class, args);
		System.out.println("JAI SHREE RAM!");
		System.out.println("APPLICATION STARTED");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductDao productDao) {
		return runner -> {
//			productDao.save(new Product("A", "ABC", "Mobile", 12, 1, 1, 5));
		};
	}

}
