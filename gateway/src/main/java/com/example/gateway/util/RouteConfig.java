package com.example.gateway.util;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public GlobalFilter filter1(){
        return new CustomGlobalFilter_1();
    }
    @Bean
    public GlobalFilter filter2(){
        return new CustomGlobalFilter_2();
    }
}
