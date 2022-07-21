package com.eureka.eureka_client.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    @GetMapping("/user/date")
    public String user(){
        log.info(" Date !!");
        return " Date !!";
    }

    @GetMapping("/user/cookie")
    public String auth(){
        log.info(" Cookie !!");
        return " Cookie !!";
    }

    @GetMapping("/user/method")
    public String addRequestHeader(){
        log.info(" Method  !! ");
        return " Method  !! ";
    }

    @GetMapping("/user/add")
    public String addResponseHeader(@RequestHeader(value = "token") String token,
                                    HttpServletResponse response){
        log.info("token = {}", token);
        response.setHeader("token", token);
        return " AddRequest&Response Header  !! ";
    }

    @GetMapping("/user/java")
    public String eurekaClientUser(){
        return "Java Config !!!";
    }

}
