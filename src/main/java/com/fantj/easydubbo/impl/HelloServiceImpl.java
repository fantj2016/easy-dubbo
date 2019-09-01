package com.fantj.easydubbo.impl;

import com.fantj.easydubbo.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello: "+ name;
    }
}
