package com.fantj.easydubbo.framework;

import com.fantj.easydubbo.protocol.dubbo.DubboProtocol;
import com.fantj.easydubbo.protocol.http.HttpProtocol;
import org.springframework.util.StringUtils;

public class ProtocolFactory {
    public static Protocol getProtocol(){

        // 工厂模式
        String name = System.getProperty("protocolName");
        if (StringUtils.isEmpty(name)){
            name = "http";
        }
        switch (name){
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
