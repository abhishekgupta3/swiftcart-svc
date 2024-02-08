package com.ecommerce.swiftcart;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.sampleProducts.SampleProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiftcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftcartApplication.class, args);
		System.out.println("HELLO WORLD");
	}

}
