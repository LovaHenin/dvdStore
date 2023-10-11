package com.simplon.dvdstore.controllers;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
public class UserProfileDto {
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    public UserProfileDto(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

}
