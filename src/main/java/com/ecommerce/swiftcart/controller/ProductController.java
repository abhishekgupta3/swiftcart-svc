package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.errorHandler.ProductException;
import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.services.ProductCategoryService;
import com.ecommerce.swiftcart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product")
    public ResponseEntity getProduct(@RequestParam(name = "productId", required = false) Integer productId) throws ProductException {
        if (productId != null) {
            Product product = productService.getProduct(productId);
            if (product == null) {
                throw new ProductException("Product not found");
            } else return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.ok(productService.getAllProduct());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product-type")
    public ResponseEntity getProductsByType(@RequestParam(name = "type", required = false) String type) {
        if (type != null)
            return ResponseEntity.ok(productService.getProductByType(type));
        else
            return ResponseEntity.ok(productCategoryService.getAllProductCategories());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/featured-products")
    public ResponseEntity getFeaturedProducts() {
        return ResponseEntity.ok(productService.getFeaturedProducts());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/product")
    public ResponseEntity getProduct(@RequestPart(name = "product") Product product, @RequestPart(name = "image")MultipartFile file) throws Exception {
        System.out.println(product);
        try {
            productService.addProduct(product, file);
        }
        catch (Exception err) {
            throw new Exception(err);
        }
        return ResponseEntity.ok("Product added to DB");
    }
}