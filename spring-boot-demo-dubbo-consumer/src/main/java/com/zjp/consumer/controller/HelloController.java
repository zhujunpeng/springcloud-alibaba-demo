package com.zjp.consumer.controller;

import com.zjp.common.HelloService;
import com.zjp.consumer.qo.HelloQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Hello服务API
 * @Author: zhujunpeng
 * @Date: 2020/12/11 10:44
 * @version: v1.0
 */
@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {
    @DubboReference
    private HelloService helloService;

    @GetMapping("say")
    public String sayHello(@RequestParam String name) {
        log.info("i'm ready to call someone......");
        return helloService.sayHello(name);
    }

    @PostMapping("say2")
    public String sayHello2(@Validated @RequestBody HelloQuery helloQuery) {
        log.info("i'm ready to call someone......");
        return helloService.sayHello(helloQuery.getHello());
    }
}
