package com.zjp.auth.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

/**
 * @author zjp
 */
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET = "secret";
    private static final String ISS = "joybo";
    /**
     * 角色的key
      */
    private static final String ROLE_CLAIMS = "rol";
    /**
     * 手机登陆，那么token有效期延长到30天
     */
    private static final long EXPIRATION_MOBILE = 2592000L;


    /**
     * 创建token
      */
    public static String createToken(String username,String role, boolean isRememberMe,boolean isMobile) {
//        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        // 记住我跟手机登陆互斥
//        if(isMobile){
//            expiration = EXPIRATION_MOBILE;
//        }
        // 默认过期时间为30天
        long expiration = EXPIRATION_MOBILE * 12;
//        long expiration = 10 * 60;
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }
    /**
     *
     从token中获取用户名
     */
    public static String getUsername(String token){
        // get
        return getTokenBody(token.replace(JwtTokenUtils.TOKEN_PREFIX,"")).getSubject();
    }
    /**
     *
     获取用户角色
     */
    public static String getUserRole(String token){
        return (String) getTokenBody(token.replace(JwtTokenUtils.TOKEN_PREFIX,"")).get(ROLE_CLAIMS);
    }
    /**
     *
     token 是否已过期
     */
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 获取Claims
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


}
