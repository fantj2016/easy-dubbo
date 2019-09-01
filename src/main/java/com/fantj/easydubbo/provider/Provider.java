package com.fantj.easydubbo.provider;

import com.fantj.easydubbo.api.HelloService;
import com.fantj.easydubbo.framework.Protocol;
import com.fantj.easydubbo.framework.ProtocolFactory;
import com.fantj.easydubbo.protocol.http.HttpProtocol;
import com.fantj.easydubbo.protocol.http.HttpServer;
import com.fantj.easydubbo.impl.HelloServiceImpl;
import com.fantj.easydubbo.register.LocalRegister;
import com.fantj.easydubbo.register.RemoteRegister;
import com.fantj.easydubbo.register.URL;

public class Provider {
    public static void main(String[] args) {
        // 1. 本地注册
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 2. 远程注册
        URL url = new URL("localhost", 8080);
        RemoteRegister.register(HelloService.class.getName(), url);

        // 3. 启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);

    }
}
