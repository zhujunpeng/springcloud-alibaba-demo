package com.zjp.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.zjp.*")
@EnableDiscoveryClient
@DubboComponentScan("com.zjp.provider.service")
@EnableDubbo
public class SpringBootDemoDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboProviderApplication.class, args);
    }

}
