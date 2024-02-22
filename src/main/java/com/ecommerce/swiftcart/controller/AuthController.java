package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.services.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth")
@RestController
public class AuthController {

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @PostMapping("register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {
        user.setRole("CUSTOMER");
        System.out.println("User " + user);

        try {
            userDetailsServiceImp.saveUser(user);
        }
        catch (Exception error) {
            throw new Exception("User couldn't be saved " + error);
        }

        return ResponseEntity.ok("User saved successfully.");
    }
}
