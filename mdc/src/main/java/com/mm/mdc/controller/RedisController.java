package com.mm.mdc.controller;

import com.mm.mdc.feign.ConfigFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    ConfigFeign configFeign;

    @RequestMapping("/hi")
    public String index(@RequestParam String name) {
        return String.format("Hi %s, I am %s, get config: %s", name, serverPort, configFeign.getConfigEnv());
    }
}
