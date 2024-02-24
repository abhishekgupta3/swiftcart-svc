package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.sampleProducts.SampleProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCartService {
    @Autowired
    SampleProducts sampleProducts;

    public Product[] getCartItems() {
        List<Product> listOfFeaturedProducts = new ArrayList<>(sampleProducts.products);
        return listOfFeaturedProducts.subList(0, 5).toArray(new Product[0]);
    }
}
