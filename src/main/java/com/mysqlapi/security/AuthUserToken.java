package com.mysqlapi.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserToken implements Authentication {

    private String username;
    private List<String> userRolesList;

    public AuthUserToken(String username, List<String> userRoles) {
        this.username = username;
        this.userRolesList = userRoles;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public boolean isAuthenticated() {
        return true;
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
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        for (String userRoleString : userRolesList) {
            authorities.add(new SimpleGrantedAuthority(userRoleString));
        }
        return authorities;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public String getName() {
        return this.username;
    }

}
