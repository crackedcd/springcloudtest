package com.mm.mapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.mm.mapi.feign"})
public class MapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapiApplication.class, args);
    }
}
