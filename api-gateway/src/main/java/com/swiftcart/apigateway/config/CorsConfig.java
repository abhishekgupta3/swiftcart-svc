//package com.swiftcart.apigateway.config;
//
//import com.google.common.net.HttpHeaders;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.CorsRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
//@Configuration
//public class CorsConfig implements WebFluxConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .exposedHeaders(HttpHeaders.SET_COOKIE);
//    }
//
//}
