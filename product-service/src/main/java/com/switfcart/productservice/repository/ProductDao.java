package com.switfcart.productservice.repository;


import com.switfcart.productservice.models.Product;

public interface ProductDao {
    void save(Product product);

    Product findProductById(int id);

    Product[] findProductByType(int typeId);

    Product[] getAllProducts();

    Product[] findProductBySearchKey(String searchKey);
}
