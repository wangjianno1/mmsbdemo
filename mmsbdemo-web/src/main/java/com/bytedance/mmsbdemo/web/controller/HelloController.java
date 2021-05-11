package com.bytedance.mmsbdemo.web.controller;

import com.bytedance.mmsbdemo.common.IpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        System.out.println("test....");
        System.out.println(IpUtils.ip2Numeric("255.255.255.255"));
        return "Greetings from Spring Boot!";
    }

}
