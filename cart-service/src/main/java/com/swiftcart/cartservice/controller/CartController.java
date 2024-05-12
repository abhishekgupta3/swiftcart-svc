package com.swiftcart.cartservice.controller;

import com.swiftcart.cartservice.dto.ResponseDto;
import com.swiftcart.cartservice.services.UserCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    UserCartService userCartService;

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping("")
    public ResponseEntity getCart(@RequestHeader String username) throws Exception {
        logger.info("Get cart item controller");
        return ResponseEntity.ok(userCartService.getCartItems(username));
    }

    @GetMapping("/{productId}")
    public ResponseEntity addCart(@PathVariable Integer productId, @RequestHeader String username) throws Exception {
        try {
            userCartService.addToCart(productId, username);
        }
        catch (Exception error) {
            throw new Exception(error);
        }

        return ResponseEntity.ok(new ResponseDto("Item Added to Cart"));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity removeCart(@PathVariable Integer productId, @RequestHeader String username) throws Exception {
        try {
            userCartService.removeItemFromCart(productId, username);
        }
        catch (Exception error) {
            throw new Exception(error);
        }
        return ResponseEntity.ok(userCartService.getCartItems(username));
    }
}
