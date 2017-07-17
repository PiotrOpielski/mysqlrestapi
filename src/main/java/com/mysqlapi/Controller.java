package com.mysqlapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Controller {
    @RequestMapping("")
    public String homepageController(){
        return "MySQL REST api homepage.";
    }

}
