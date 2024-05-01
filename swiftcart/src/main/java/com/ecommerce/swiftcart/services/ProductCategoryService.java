package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.ProductType;
import com.ecommerce.swiftcart.repository.ProductCategoryDao;
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
