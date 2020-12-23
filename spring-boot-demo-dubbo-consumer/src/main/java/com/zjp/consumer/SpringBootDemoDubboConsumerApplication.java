package com.zjp.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "com.zjp.*")
@EnableDiscoveryClient
@EnableDubbo
public class SpringBootDemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboConsumerApplication.class, args);
    }

}
