package com.switfcart.userservice.controller;

import com.switfcart.userservice.dto.AuthRequestDto;
import com.switfcart.userservice.dto.AuthResponseDto;
import com.switfcart.userservice.dto.ResponseDto;
import com.switfcart.userservice.dto.UserDataResponseDto;
import com.switfcart.userservice.models.User;
import com.switfcart.userservice.services.UserDetailsServiceImpl;
import com.switfcart.userservice.utils.JwtUtilsService;
import com.switfcart.userservice.utils.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    Logger logger = LoggerFactory.getLogger(AuthController.class);


    @GetMapping("users")
    public ResponseEntity getAllUsers() {
        List<UserDataResponseDto> users = userDetailsServiceImpl.getAllUsers();
        logger.info("/users GET ALL USERS");
        return ResponseEntity.ok(users);
    }

    @GetMapping("user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        logger.info("GET USER " + username);
        return ResponseEntity.ok(userDetailsServiceImpl.getUserByUsername(username));
    }

    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody User user) throws Exception {
        logger.info("Add new User " + user);
        if (!Validation.validateUserName(user.getUsername()) || !Validation.validatePassword(user.getPassword())) {
            logger.error("Invalid username or password");
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
            logger.error("User couldn't be saved " + error);
            throw new Exception("User couldn't be saved " + error);
        }

        return ResponseEntity.ok(new ResponseDto("User saved successfully."));
    }

    @PostMapping("/login")
    public AuthResponseDto authenticateAndGetToken(@RequestBody AuthRequestDto authRequest) {
        logger.info("/login LOGIN USER " + authRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            logger.info("USER AUTHENTICATED");
            return new AuthResponseDto(jwtService.generateToken(authRequest.getUsername()), "Login Success");
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
