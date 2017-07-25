package com.mysqlapi;

import com.mysqlapi.exception.StatementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_USER")
    @RequestMapping(value = "/api/{statement}/{value1}", method = RequestMethod.GET)
    public List<Map<String, Object>> selectAllFromTable(@PathVariable String statement, @PathVariable String value1) throws StatementNotFoundException {
        if (!statementsController.getStatementFromId(statement).equals(null)) {
            System.out.println(statementsController.getStatementFromId(statement));
            return jdbcTemplate.queryForList(statementsController.getStatementFromId(statement), new Object[]{value1});
        }
           throw new StatementNotFoundException(statement);
    }


}
