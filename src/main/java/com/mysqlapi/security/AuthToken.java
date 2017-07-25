package com.mysqlapi.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class AuthToken implements Authentication {

    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
