package com.zjp.provider.service;

import com.zjp.common.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @Author: zhujunpeng
 * @Date: 2020/12/11 10:47
 * @version: v1.0
 */
@DubboService
@Component
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        log.info("someone is calling me......");
        return "say hello to: " + name;
    }
}
