package com.example.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPostFilter extends AbstractGatewayFilterFactory<CustomPostFilter.Config> {


    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpResponse response = exchange.getResponse();
            log.info("post Filter");
            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}
