package com.swiftcart.cartservice.client;

import com.swiftcart.cartservice.dto.ProductDto;
import com.swiftcart.cartservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", path = "/product")
public interface ProductServiceClient {
    @GetMapping("")
    ResponseEntity<ProductDto> getProduct(@RequestParam(name = "productId") Integer productId);
}
