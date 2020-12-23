package com.zjp.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 限流相关配置
 * @Author: zhujunpeng
 * @Date: 2020/12/23 14:17
 * @version: v1.0
 */
@Configuration
public class RateLimitConfig {
    /**
     * 根据用户id地址限流
     * @return
     */
    @Bean
    public KeyResolver hostAddrKeyResolver() {
        // ip地址
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName()
                // 用户id
                + exchange.getRequest().getQueryParams().getFirst("userId")
                // 接口地址
                + exchange.getRequest().getPath().value());
    }
}
