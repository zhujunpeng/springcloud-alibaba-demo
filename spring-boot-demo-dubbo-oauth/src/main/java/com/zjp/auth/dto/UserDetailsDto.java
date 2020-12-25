package com.zjp.auth.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @Author: zhujunpeng
 * @Date: 2020/12/25 9:25
 * @version: v1.0
 */
@Data
public class UserDetailsDto implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserDetailsDto(String username, String password, List<GrantedAuthority> authorities) {
        this.authorities = authorities;
        this.password = password;
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
