package com.fantj.easydubbo.framework;

import com.fantj.easydubbo.protocol.http.HttpClient;
import com.fantj.easydubbo.protocol.http.HttpProtocol;
import com.fantj.easydubbo.register.RemoteRegister;
import com.fantj.easydubbo.register.URL;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getProxy(Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Protocol protocol = ProtocolFactory.getProtocol();
                        Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                        // 从注册中心查地址 来调用
                        URL url = RemoteRegister.get(interfaceClass.getName());
                        String result = protocol.send(url, invocation);
                        return result;
                    }
                });
    }
}
