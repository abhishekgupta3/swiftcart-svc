package com.switfcart.productservice.repository;

import com.switfcart.productservice.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductType, Integer> {
    @Query("SELECT p.name FROM ProductType p")
    ProductType[] getAllDistinctProductCategories();
}
