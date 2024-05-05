package com.swiftcart.apigateway.config;

import com.swiftcart.apigateway.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    JwtAuthFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))

                .route("product-service", r -> r.path("/**")
                        .uri("lb://product-service"))

                .route("cart-service", r -> r.path("/cart/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://cart-service"))

                .route("order-service", r -> r.path("/order/**")
                        .uri("lb://order-service"))

                .build();
    }
}
