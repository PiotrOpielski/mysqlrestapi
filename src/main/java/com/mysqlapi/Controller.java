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

    @RequestMapping(value = "/api/{statement}/{value1}", method = RequestMethod.GET)
    public List<Map<String, Object>> selectAllFromTable(@PathVariable String statement, @PathVariable String value1) {
        if (!statementsController.getStatementFromId(statement).equals(null)) {
            System.out.println(statementsController.getStatementFromId(statement));
            return jdbcTemplate.queryForList(statementsController.getStatementFromId(statement), new Object[]{value1});
        } else{
            return jdbcTemplate.queryForList("SELECT * FROM def WHERE id=1;");
        }
    }


}
