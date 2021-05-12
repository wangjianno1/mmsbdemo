package com.bytedance.mmsbdemo.service.impl;

import com.bytedance.mmsbdemo.common.IpUtils;
import com.bytedance.mmsbdemo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void hello() {
        System.out.println("23.23.23.23 number is: " + IpUtils.ip2Numeric("23.23.23.23"));
        System.out.println("HelloServiceImpl.hello done.");
    }
}
