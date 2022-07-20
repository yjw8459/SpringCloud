package com.example.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class CustomGlobalFilter_1 implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.error("First Global Filter PreLogging -> Order is 10");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.error("First Global Filter PostLogging -> Order is 10");
        }));
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
