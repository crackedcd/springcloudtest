package com.mm.mconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MconfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MconfigclientApplication.class, args);
    }
}
