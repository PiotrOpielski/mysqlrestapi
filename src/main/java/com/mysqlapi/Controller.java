package com.mysqlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StatementsController statementsController;

    @RequestMapping("/")
    public String homepageController() {

        return "MySQL REST api homepage.";
    }

    @RequestMapping(value = "testTable/{table}", method = RequestMethod.GET)
    public List<Map<String, Object>> selectAllFromTable(@PathVariable String table) {

        return jdbcTemplate.queryForList("SELECT * FROM testTable WHERE id = ? ;", new Object[]{table});

    }


}
