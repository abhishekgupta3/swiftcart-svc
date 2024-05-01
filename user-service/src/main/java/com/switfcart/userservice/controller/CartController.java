package com.switfcart.userservice.controller;

import com.switfcart.userservice.dto.ResponseDto;
import com.switfcart.userservice.services.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    UserCartService userCartService;

    @GetMapping("")
    public ResponseEntity getCart() {
        return ResponseEntity.ok(userCartService.getCartItems());
    }

    @GetMapping("{productId}")
    public ResponseEntity addCart(@PathVariable Integer productId) throws Exception {
        try {
            userCartService.addToCart(productId);
        }
        catch (Exception error) {
            throw new Exception(error);
        }

        return ResponseEntity.ok(new ResponseDto("Item Added to Cart"));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity removeCart(@PathVariable Integer productId) throws Exception {
        try {
            userCartService.removeItemFromCart(productId);
        }
        catch (Exception error) {
            throw new Exception(error);
        }
        return ResponseEntity.ok(userCartService.getCartItems());
    }
}
