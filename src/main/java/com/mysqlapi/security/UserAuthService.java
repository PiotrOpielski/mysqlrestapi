package com.mysqlapi.security;

import com.mysqlapi.exception.FailedToLoginException;
import com.mysqlapi.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class UserAuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public String authenticateUser(String username, String password) throws FailedToLoginException {
        boolean isAuthenticated = false;
        if (username.equals("admin") && password.equals("test123")) {
            isAuthenticated = true;
        } else if (username.equals("user") && password.equals("test123")) {
            isAuthenticated = true;
        }

        if (isAuthenticated) {
            try {
                return jwtService.generateToken(username);
            } catch (URISyntaxException | IOException e) {
                throw new FailedToLoginException(e.getMessage());
            }
        }
        throw new FailedToLoginException(String.format("unable to authenticate user [%s]", username));
    }

    public User authenticateToken(String jwtToken) throws AuthException {

        try {
            String username = jwtService.verifyToken(jwtToken);
            List<String> userRoles = userService.getUserRoles(username);

            User user = new User();
            user.setUsername(username);
            user.setUserRoles(userRoles);
            return user;
        } catch (IOException | URISyntaxException e) {
            throw new AuthException(e.getMessage(), e);
        }
    }

}

