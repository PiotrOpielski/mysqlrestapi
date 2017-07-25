package com.mysqlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class MysqlapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlapiApplication.class, args);
    }

    @Bean
    public StatementsController statementsController() throws IOException {
        return new StatementsController("/home/piotr/IdeaProjects/mysqlapi/build/resources/main/statements.json");
    }
}
