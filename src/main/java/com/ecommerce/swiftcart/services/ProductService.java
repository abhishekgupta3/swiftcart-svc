package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.models.ProductType;
import com.ecommerce.swiftcart.repository.ProductDao;
import com.ecommerce.swiftcart.sampleProducts.SampleProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    @Autowired
    SampleProducts sampleProducts;

    public Product[] getAllProduct() {
        return sampleProducts.products.toArray(new Product[0]);
    }

    public Product getProduct(int id) {
//        List<Product> listOfProductsById = sampleProducts.products.stream().filter(p -> p.getId() == id).toList();
//        return listOfProductsById.get(0);
        return productDao.findProductById(id);
    }

    public Product[] getProductByType(String type) {
//        List<Product> listOfProductsByType = sampleProducts.products
//                .stream()
//                .filter(p -> Objects.equals(p.getType().toLowerCase(), type.toLowerCase()))
//                .toList();
//        return listOfProductsByType.toArray(new Product[0]);
        return productDao.findProductByType(type);
    }

    public ProductType[] getAllProductType() {
        return sampleProducts.productsType.toArray(new ProductType[0]);
    }

    public Product[] getFeaturedProducts() {
        List<Product> listOfFeaturedProducts = new ArrayList<>(sampleProducts.products);
        listOfFeaturedProducts.sort((a, b) -> b.getDiscount() - a.getDiscount());
        return listOfFeaturedProducts.subList(0, 5).toArray(new Product[0]);
    }

    public Product[] getCartItems() {
        List<Product> listOfFeaturedProducts = new ArrayList<>(sampleProducts.products);
        return listOfFeaturedProducts.subList(0, 5).toArray(new Product[0]);
    }
}
