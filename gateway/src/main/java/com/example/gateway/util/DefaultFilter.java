package com.example.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.ObjectInputFilter;

@Slf4j
@Component
public class DefaultFilter extends AbstractGatewayFilterFactory<DefaultConfig> {
    public DefaultFilter() {
        super(DefaultConfig.class);
    }

    @Override
    public GatewayFilter apply(DefaultConfig config) {
        return ( exchange, chain ) -> {
            log.info("Default Filter baseMessage: {}", config.getBaseMessage());
            if ( config.isPreLogger() ){
                log.info("GlobalFilter Start = {}", exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if ( config.isPostLogger() ){
                    log.info("GlobalFilter End :{}", exchange.getResponse());
                }
            }));
        };
    }
}
