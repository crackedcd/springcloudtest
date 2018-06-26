package com.mm.mdc.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MdcConfig {

    @Value("${config.name}")
    private String configName;

    public String getConfigName() {
        return configName;
    }
}
