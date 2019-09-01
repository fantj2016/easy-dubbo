package com.fantj.easydubbo.framework;

import com.fantj.easydubbo.register.URL;

public interface Protocol {
    void start(URL url);
    String send(URL url, Invocation invocation);
}
