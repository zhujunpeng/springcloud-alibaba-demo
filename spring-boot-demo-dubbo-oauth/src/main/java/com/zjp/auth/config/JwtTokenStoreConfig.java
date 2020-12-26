package com.zjp.auth.config;

import com.zjp.auth.util.JwtTokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用Jwt存储token的配置
 * @Author: zhujunpeng
 * @Date: 2020/12/26 9:36
 * @version: v1.0
 */
@Configuration
public class JwtTokenStoreConfig {
    @Bean("jwtTokenStore")
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(JwtTokenUtils.SECRET);//配置JWT使用的秘钥
        return accessTokenConverter;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return (accessToken, oAuth2Authentication) -> {
            Object principal = oAuth2Authentication.getPrincipal();
            Map<String, Object> info = new HashMap<>();
            info.put("userInfo", principal);
            info.put("time",System.currentTimeMillis());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
            return accessToken;
        };
    }
}
