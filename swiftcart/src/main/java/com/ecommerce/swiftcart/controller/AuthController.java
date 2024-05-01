package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.dto.AuthRequestDto;
import com.ecommerce.swiftcart.dto.AuthResponseDto;
import com.ecommerce.swiftcart.dto.ResponseDto;
import com.ecommerce.swiftcart.dto.UserDataResponseDto;
import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.services.UserDetailsServiceImpl;
import com.ecommerce.swiftcart.utils.JwtUtilsService;
import com.ecommerce.swiftcart.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("auth")
@RestController
public class AuthController {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private JwtUtilsService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("users")
    public ResponseEntity getAllUsers() {
        List<UserDataResponseDto> users = userDetailsServiceImpl.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody User user) throws Exception {
        if (!Validation.validateUserName(user.getUsername()) || !Validation.validatePassword(user.getPassword())) {
            throw new Exception("Invalid username or password");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getUsername().equals("admin")) {
            user.setRole("ADMIN");
        }
        else {
            user.setRole("CUSTOMER");
        }

        try {
            userDetailsServiceImpl.saveUser(user);
        }
        catch (Exception error) {
            throw new Exception("User couldn't be saved " + error);
        }

        return ResponseEntity.ok(new ResponseDto("User saved successfully."));
    }

    @PostMapping("/login")
    public AuthResponseDto authenticateAndGetToken(@RequestBody AuthRequestDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new AuthResponseDto(jwtService.generateToken(authRequest.getUsername()), "Login Success");
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
