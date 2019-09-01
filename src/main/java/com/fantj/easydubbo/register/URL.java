package com.fantj.easydubbo.register;

import lombok.Data;

import java.io.Serializable;

@Data
public class URL implements Serializable {
    private String hostname;
    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }
}
