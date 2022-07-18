package com.example.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * 사용자 정의 필터를 만들기 위해선 Spring Cloud Gateway가 추상화해놓은
 * AbstractGatewayFilterFactory를 상속
 *
 * GatewayFilterFactory를 구현할 때 사용자 로직을 넣는다.
 * 추상화 메서드를 GatewayFilterFactory.apply()를 override
 */
@Component
@Slf4j
public class CustomAuthFilter extends AbstractGatewayFilterFactory<CustomAuthFilter.Config> {

    public CustomAuthFilter(){
        super(Config.class);
    }

    // 사용자 로직 작성
    @Override
    public GatewayFilter apply(Config config){
        // 첫 번째 매개변수(exchange)는 ServerWebExchange 형태,
        // 두 번째 매개변수(chain)는 GatewayFilterChain 람다 함수
        // exchange : ServletRequest, Response X, Spring Reactive Request,Response O
        return (((exchange, chain) -> {
            // exchange.getRequest();    Pre Filter
            // exchange.getResponse();   Post Filter
            //ServerHttpRequest request = exchange.getRequest();  // Spring Reactive Request
            log.info("preFilter");
            ServerHttpResponse response = exchange.getResponse();
            // Request Header에 token이 존재하지 않을 때
            if ( ! response.getHeaders().containsKey("token") ){
                return handleUnAuthorized(exchange);
            }
            // Request Header에서 token을 가져옴
            List<String> token = response.getHeaders().get("token");
            String tokenString = Objects.requireNonNull(token).get(0);
            // 토큰 검증
            if ( ! tokenString.equals("A.B.C") ){
                return handleUnAuthorized(exchange);    // 토큰이 일치하지 않을 때
            }

            return chain.filter(exchange);  // 토큰이 일치할 때
        }));
    }

    private Mono<Void> handleUnAuthorized(ServerWebExchange exchange){
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    public static class Config{

    }
}
