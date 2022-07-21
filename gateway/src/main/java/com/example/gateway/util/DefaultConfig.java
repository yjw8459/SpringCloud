package com.example.gateway.util;


import lombok.Getter;

@Getter
public class DefaultConfig {

    private String baseMessage;
    private boolean preLogger;
    private boolean postLogger;

    public DefaultConfig(String baseMessage, boolean preLogger, boolean postLogger) {
        this.baseMessage = baseMessage;
        this.preLogger = preLogger;
        this.postLogger = postLogger;
    }
}
