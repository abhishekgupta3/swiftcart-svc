package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
    @Query("SELECT DISTINCT p.name  FROM ProductType p")
    ProductType[] getAllDistinctProductCategories();
}
