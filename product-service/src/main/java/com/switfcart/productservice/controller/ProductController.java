package com.switfcart.productservice.controller;

import com.switfcart.productservice.dto.ResponseDto;
import com.switfcart.productservice.errorHandler.ProductException;
import com.switfcart.productservice.models.Product;
import com.switfcart.productservice.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") Integer productId) throws ProductException {
        logger.info("Get Product by Id " + productId);
        Product product = productService.getProduct(productId);
        if (product == null) {
            logger.error("Product not found");
            throw new ProductException("Product not found");
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public ResponseEntity<Product[]> searchProduct(@RequestParam(name = "search") String searchKey) {
        logger.info("Get product by Search key " + searchKey);
        Product[] products = productService.getProductBySearchKey(searchKey);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/all")
    public ResponseEntity<Product[]> getAllProducts() {
        logger.info("Get all products");
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("")
    public ResponseEntity addProduct(@RequestPart(name = "product") Product product, @RequestPart(name = "image")MultipartFile file) throws Exception {
        logger.info("Add Product");
        try {
            productService.addProduct(product, file);
        }
        catch (Exception err) {
            throw new Exception(err);
        }
        return ResponseEntity.ok(new ResponseDto("Product added to DB"));
    }

    @GetMapping("/featured-products")
    public ResponseEntity getFeaturedProducts() {
        logger.info("Get Featured Product");
        return ResponseEntity.ok(productService.getFeaturedProducts());
    }
}