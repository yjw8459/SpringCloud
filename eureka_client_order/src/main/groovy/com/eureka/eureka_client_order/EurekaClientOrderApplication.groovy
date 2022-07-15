package com.eureka.eureka_client_order

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class EurekaClientOrderApplication {

    static void main(String[] args) {
        SpringApplication.run(EurekaClientOrderApplication, args)
    }

}
