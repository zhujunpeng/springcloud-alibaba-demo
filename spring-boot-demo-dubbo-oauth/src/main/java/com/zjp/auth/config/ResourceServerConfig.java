package com.zjp.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源配置，
 * @Author: zhujunpeng
 * @Date: 2020/12/25 14:41
 * @version: v1.0
 */
@Configuration
// 启用资源服务
@EnableResourceServer
// 启用方法级权限控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     *  配置资源接口安全，http.authorizeRequests()针对的所有url，但是由于登录页面url包含在其中，这里配置会进行token校验，校验不通过返回错误json，
     *  而授权码模式获取code时需要重定向登录页面，重定向过程并不能携带token，所有不能用http.authorizeRequests()，
     *  而是用requestMatchers().antMatchers("")，这里配置的是需要资源接口拦截的url数组
     * @param http
     * @return void
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/user/**");//配置需要保护的资源路径
    }
}
