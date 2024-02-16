package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao {
    void save(Product product);
}
