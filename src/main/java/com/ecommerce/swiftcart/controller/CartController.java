package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.services.ProductService;
import com.ecommerce.swiftcart.services.UserCartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    UserCartService userCartService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cart")
    public ResponseEntity getCart() {
        return ResponseEntity.ok(userCartService.getCartItems());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/addcart/{productId}")
    public ResponseEntity addCart(HttpServletRequest request, @PathVariable Integer productId) throws Exception {
        try {
            userCartService.addToCart(productId);
        }
        catch (Exception error) {
            throw new Exception(error);
        }
        return ResponseEntity.ok("Item Added to Cart");
    }
}
