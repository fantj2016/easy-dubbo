package com.fantj.easydubbo.framework;

import lombok.Data;

import java.io.Serializable;


@Data
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }
}
