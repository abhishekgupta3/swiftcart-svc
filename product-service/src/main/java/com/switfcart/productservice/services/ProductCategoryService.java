package com.switfcart.productservice.services;


import com.switfcart.productservice.models.ProductType;
import com.switfcart.productservice.repository.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;

    public ProductType[] getAllProductCategories() {
        return productCategoryDao.getAllDistinctProductCategories();
    }

}
