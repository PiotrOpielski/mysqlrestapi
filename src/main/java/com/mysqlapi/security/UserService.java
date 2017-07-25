package com.mysqlapi.security;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<String> getUserRoles(String username) {

        List<String> userRoles = new ArrayList<String>();

        if (username != null && username.equals("admin")) {
            return Arrays.asList("ROLE_ADMIN");
        } else if (username != null && username.equals("user")) {
            return Arrays.asList("ROLE_USER");
        }
        return userRoles;
    }
}
