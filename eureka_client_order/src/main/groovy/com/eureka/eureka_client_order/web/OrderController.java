package com.eureka.eureka_client_order.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @GetMapping("/info")
    public String info(){
        log.info("Request Order Info !!");
        return "Request Order Info!!";
    }

    @GetMapping("/auth")
    public String auth(){
        log.info("Request Order Auth!!");
        return "Request Order Auth!!";
    }

}
