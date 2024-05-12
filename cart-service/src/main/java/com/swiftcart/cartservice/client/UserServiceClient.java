package com.swiftcart.cartservice.client;

import com.swiftcart.cartservice.dto.UserDto;
import com.swiftcart.cartservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/auth")
public interface UserServiceClient {
    @GetMapping("/user/{username}")
    ResponseEntity<UserDto> getUserByUsername(@PathVariable String username);
}
