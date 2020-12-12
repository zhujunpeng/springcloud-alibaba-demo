package com.zjp.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置nacos实现配置中心
 * @Author: zhujunpeng
 * @Date: 2020/12/12 13:56
 * @version: v1.0
 */
@RefreshScope
@RestController
@RequestMapping("sample")
public class SampleController {
    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @GetMapping("/user")
    public String getUserName(){
        return userName +":"+ age;
    }
}
