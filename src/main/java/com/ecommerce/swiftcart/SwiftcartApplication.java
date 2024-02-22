package com.ecommerce.swiftcart;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.repository.ProductDao;
import com.ecommerce.swiftcart.sampleProducts.SampleProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SwiftcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftcartApplication.class, args);
		System.out.println("HELLO WORLD");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductDao productDao) {
		return runner -> {
//			productDao.save(new Product("A", "ABC", "Mobile", 12, 1, 1, 5));
		};
	}

}
