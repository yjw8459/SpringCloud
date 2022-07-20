package com.example.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class CustomGlobalFilter_2 implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.error("Second Global Filter PreLogging -> Order is 5");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.error("Second Global Filter PostLogging -> Order is 5");
        }));
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
