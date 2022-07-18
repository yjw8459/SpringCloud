package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  SCG :
 *      API Gateway를 수행하는 Spring Cloud의 공식 프로젝트
 *      Netflix Zuul 과 같은 기능을 수행하지만 비동기 수행을 위해 Spring WebFlux로 Netty 위에서 동작하는
 *      Spring boot application이다.
 *
 *      다양한 마이크로서비스들을 Gateway에 연결시켜 모든 서비스들의 진입점으로 만들 수 있고 Gateway 내에서
 *      HTTP 요청에 대한 다양한 조작을 할 수 있다.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
