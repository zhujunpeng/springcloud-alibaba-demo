package com.zjp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication(scanBasePackages = "com.zjp.*")
@EnableDiscoveryClient
@EnableAuthorizationServer
public class SpringBootDemoDubboOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboOauthApplication.class, args);
    }

}
