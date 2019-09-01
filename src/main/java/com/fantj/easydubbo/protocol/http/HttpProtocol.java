package com.fantj.easydubbo.protocol.http;

import com.fantj.easydubbo.framework.Invocation;
import com.fantj.easydubbo.framework.Protocol;
import com.fantj.easydubbo.protocol.dubbo.NettyClient;
import com.fantj.easydubbo.protocol.dubbo.NettyServer;
import com.fantj.easydubbo.register.URL;

public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().post(url.getHostname(), url.getPort(), invocation);
    }
}
