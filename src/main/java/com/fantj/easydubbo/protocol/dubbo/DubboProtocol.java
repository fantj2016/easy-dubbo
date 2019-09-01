package com.fantj.easydubbo.protocol.dubbo;

import com.fantj.easydubbo.framework.Invocation;
import com.fantj.easydubbo.framework.Protocol;
import com.fantj.easydubbo.register.URL;

public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {
//        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
//        new NettyClient().send(url.getHostname(), url.getPort(), invocation);
        return null;
    }
}
