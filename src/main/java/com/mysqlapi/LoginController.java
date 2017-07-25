package com.mysqlapi;


import com.mysqlapi.exception.FailedToLoginException;
import com.mysqlapi.security.AuthResponse;
import com.mysqlapi.security.UserAuthService;
import com.mysqlapi.security.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserAuthService authenticationService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthResponse authenticationResponse(@RequestBody UserCredentials userCredentials) throws FailedToLoginException {
        if (userCredentials == null || (userCredentials.getUsername() == null || userCredentials.getPassword() == null)) {
            throw new FailedToLoginException("Missing credentials");
        }
        String token = authenticationService.authenticateUser(userCredentials.getUsername(), userCredentials.getPassword());

        if (token != null) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setUsername(userCredentials.getUsername());
            authResponse.setToken(token);
            return authResponse;
        }
        throw new FailedToLoginException(String.format(" unable to authenticate user [%s] ", userCredentials.getUsername()));

    }

}
