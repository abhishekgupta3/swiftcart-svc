package com.switfcart.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", path = "/auth")
public interface UserServiceClient {
    @GetMapping("/user")
    public ResponseEntity getCurrentUser();
}
