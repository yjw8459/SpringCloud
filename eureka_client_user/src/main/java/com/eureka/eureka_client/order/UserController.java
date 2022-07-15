package com.eureka.eureka_client.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    @GetMapping("/user")
    public ModelAndView user(){
        log.info("Request User !!");
        return new ModelAndView();
    }
}
