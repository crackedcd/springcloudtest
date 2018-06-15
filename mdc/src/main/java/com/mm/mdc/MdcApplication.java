package com.mm.mdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.mm.mdc.feign"})
public class MdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdcApplication.class, args);
    }
}
