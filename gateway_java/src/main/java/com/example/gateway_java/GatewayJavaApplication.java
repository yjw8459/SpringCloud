package com.example.gateway_java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class GatewayJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayJavaApplication.class, args);
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        log.info("tetetete");
        log.info("tetetete");
        log.info("tetetete");
        return Mono.just("fallback");
    }

}
