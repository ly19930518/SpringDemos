package com.tl.controller;

import com.tl.mq.produce.QueueProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CATALINA_BASE=/usr/java/tomcat
 * CATALINA_HOME=/usr/java/tomcat
 * TOMCAT_HOME=/usr/java/tomcat
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello")
    public String hello(){
        List<ServiceInstance> instances = client.getInstances("spring-test-service");
        for (int i = 0; i < instances.size(); i++) {
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }

        return "hello world";
    }
}
