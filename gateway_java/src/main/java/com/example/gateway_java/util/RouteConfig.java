package com.example.gateway_java.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RouteConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/user/java")
                        .filters(f -> f.addResponseHeader("Hello", "World"))
                        .uri("http://localhost:8080/user/java"))
                .build();
    }
}
