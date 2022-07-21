package com.example.gateway_java.util;


import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Slf4j
public class CirCuitBreakerConfig {

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> myCB() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED.COUNT_BASED)
                .slidingWindowSize(10) // # {통계건수}
                            .minimumNumberOfCalls(2) //# {최소요청횟수}
                            .failureRateThreshold(60) //# {실패율}
                            .waitDurationInOpenState(Duration.ofMillis(10000)) //# {Circuit Breaker유지시간}
                            .build();
        return factory -> factory.configure(builder -> builder.circuitBreakerConfig(config)
                .build(), "mycb");
    }
}
