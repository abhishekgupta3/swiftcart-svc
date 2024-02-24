package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductDao {
    void save(Product product);

    Product findProductById(int id);

    Product[] findProductByType(String type);

    Product[] getAllProducts();
}
