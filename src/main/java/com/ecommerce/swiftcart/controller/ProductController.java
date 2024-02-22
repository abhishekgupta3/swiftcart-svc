package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.errorHandler.ProductException;
import com.ecommerce.swiftcart.errorHandler.RestExceptionHandler;
import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product")
    public ResponseEntity getProduct(@RequestParam(name = "productId", required = false) Integer productId) throws ProductException{
        if (productId != null) {
            Product product = productService.getProduct(productId);
            System.out.println(product);

            if (product == null) {
                throw new ProductException("Product not found");
            }
            else return ResponseEntity.ok(product);
        }
        else {
            return ResponseEntity.ok(productService.getAllProduct());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product-type")
    public ResponseEntity getProductsByType(@RequestParam(name = "type", required = false) String type) {
        if (type != null)
            return ResponseEntity.ok(productService.getProductByType(type));
        else
            return ResponseEntity.ok(productService.getAllProductType());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/featured-products")
    public ResponseEntity getFeaturedProducts() {
        return ResponseEntity.ok(productService.getFeaturedProducts());
    }

    @GetMapping("/error")
    public String error() {
        return "Error244";
    }

}
