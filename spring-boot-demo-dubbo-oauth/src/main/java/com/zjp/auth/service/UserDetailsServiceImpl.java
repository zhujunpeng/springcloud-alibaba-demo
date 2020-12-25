package com.zjp.auth.service;

import com.zjp.auth.dto.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhujunpeng
 * @Date: 2020/12/25 9:27
 * @version: v1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private List<UserDetailsDto> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 造一些数据，后续改造成从数据库获取
     */
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDetailsDto("zzzz", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new UserDetailsDto("jjjj", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new UserDetailsDto("pppp", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsDto> detailsDtos = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(detailsDtos)){
            return detailsDtos.get(0);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
