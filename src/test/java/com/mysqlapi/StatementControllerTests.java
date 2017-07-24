package com.mysqlapi;


import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StatementControllerTests {

    StatementsController statementsController = null;
    String statements = null;

    public StatementControllerTests() throws IOException {
        statementsController = new StatementsController("src/test/resources/statements.json");
    }


    @Test
    public void testGetFileAsString() throws Exception {
        assertEquals(statementsController.getJSONFileString(), "[{\"id\":1,\"fieldInt\":5,\"fieldString\":\"test\"}]");
    }

    @Test
    public void testGetStringAsJSONObject() throws Exception {
        assertEquals(statementsController.getJSONFileArray().getJSONObject(0).getString("fieldString"), "test");

    }


}


