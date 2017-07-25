package com.mysqlapi.security;


import com.mysqlapi.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserAuthService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = null;
        try {
            user = authenticationService.authenticateToken((String) authentication.getCredentials());
        } catch (AuthException e) {
            e.printStackTrace();
        }
        return new AuthUserToken(user.getUsername(), user.getUserRoles());
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return AuthToken.class.equals(aClass);
    }
}
