package com.tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value="test-consumer")
    public String HelloController(){
        return restTemplate.getForEntity("http://SPRING-TEST-SERVICE/hello",String.class).getBody();
    }
}
