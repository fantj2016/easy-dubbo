package com.fantj.easydubbo.consume;

import com.fantj.easydubbo.api.HelloService;
import com.fantj.easydubbo.framework.ProxyFactory;

public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        System.out.println(helloService.sayHello("fantj666"));

    }
}
