package com.mm.mconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${config.env}")
    private String message;
    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    String getName() {
        return this.name;
    }

    @RequestMapping("/env")
    String getEnv() {
        return this.message;
    }
}
