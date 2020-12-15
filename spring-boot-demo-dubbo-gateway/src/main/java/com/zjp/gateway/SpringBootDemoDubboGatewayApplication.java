package com.zjp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootDemoDubboGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboGatewayApplication.class, args);
    }

}
