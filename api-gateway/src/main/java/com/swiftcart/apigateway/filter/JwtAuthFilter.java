package com.swiftcart.apigateway.filter;

import com.swiftcart.apigateway.utils.JwtUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Predicate;

@Component
public class JwtAuthFilter implements GatewayFilter {
    @Autowired
    JwtUtilsService jwtUtilsService;
    Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        List<String> apiEndpoints = List.of("/auth/login", "/auth/register", "/eureka");
        System.out.println(request.toString());
        logger.info("In api gateway");

        Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
                .noneMatch(uri -> r.getURI().getPath().contains(uri));

        if (isApiSecured.test(request)) {
//            if (!request.getHeaders().containsKey("Authorization")) {
//                return onError(exchange);
//            }

            String token = request.getHeaders().getOrEmpty("Authorization").get(0);

            if (token != null && token.startsWith("Bearer ")) token = token.substring(7);

            if (!jwtUtilsService.validateToken(token)) {
                logger.error("JWT Token Not validated");
                return onError(exchange);
            }
            logger.info("JWT Token Validated");
            request = exchange
                    .getRequest()
                    .mutate()
                    .header("username", jwtUtilsService.extractUsername(token))
                    .build();
        }
        return chain.filter(exchange.mutate().request(request).build());
    }

    private Mono<Void> onError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        logger.error("Auth failed " + response);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
