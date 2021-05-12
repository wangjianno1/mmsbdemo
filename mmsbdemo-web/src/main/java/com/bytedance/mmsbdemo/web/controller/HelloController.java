package com.bytedance.mmsbdemo.web.controller;

import com.bytedance.mmsbdemo.common.IpUtils;
import com.bytedance.mmsbdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        System.out.println("hello....");
        System.out.println("255.255.255.255 number is: " + IpUtils.ip2Numeric("255.255.255.255"));
        helloService.hello();
        return "Greetings from Spring Boot!";
    }

}
