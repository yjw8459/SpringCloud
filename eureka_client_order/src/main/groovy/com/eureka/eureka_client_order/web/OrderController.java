package com.eureka.eureka_client_order.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @GetMapping("/order")
    public ModelAndView user(){
        log.info("Request Order !!");
        return new ModelAndView();
    }
}
