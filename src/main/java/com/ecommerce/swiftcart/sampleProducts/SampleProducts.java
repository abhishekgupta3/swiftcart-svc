package com.ecommerce.swiftcart.sampleProducts;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.models.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SampleProducts {

    public List<Product> products = new ArrayList<>();
    public List<ProductType> productsType = new ArrayList<>();

    public SampleProducts() {
//        products.add(new Product(1,"A", "ABC", "Mobile", 12, 1, 1, 5));
//        products.add(new Product(2,"A", "ABC", "Mobile", 12, 19, 1, 5));
//        products.add(new Product(2,"A", "ABC", "Mobile", 12, 91, 1, 5));
//        products.add(new Product(2,"A", "ABC", "Mobile", 12, 99, 1, 5));
//        products.add(new Product(2,"A", "ABC", "Mobile", 12, 92, 1, 5));
//        products.add(new Product(2,"A", "ABC", "Mobile", 12, 12, 1, 5));
//        products.add(new Product(3,"A", "ABC", "Clothes", 12, 29, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 15, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 18, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 90, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 99, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 98, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 79, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 10, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 3, 1, 5));
//        products.add(new Product(4,"A", "ABC", "Clothes", 12, 5, 1, 5));
//        products.add(new Product(1,"A", "ABC", "Mobile", 12, 10, 1, 5));
//        products.add(new Product(1,"A", "ABC", "TV", 12, 9, 1, 5));
//        products.add(new Product(1,"A", "ABC", "TV", 12, 9, 1, 5));
//        products.add(new Product(1,"A", "ABC", "TV", 12, 9, 1, 5));

//        productsType.add(new ProductType(1, "Mobile"));
//        productsType.add(new ProductType(2, "Clothes"));
//        productsType.add(new ProductType(3, "TV"));
//        productsType.add(new ProductType(4, "Fashion"));
//        productsType.add(new ProductType(5, "Watches"));
    }

    public List<Product> getProducts() {
        return products;
    }
    public List<ProductType> getProductType() {
        return productsType;
    }
}
