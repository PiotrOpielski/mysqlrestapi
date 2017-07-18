package com.mysqlapi;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StatementControllerTests {

    StatementsController statementsController = new StatementsController();
    String statements =  null;



    @Test
    public void testGetFileAsString() throws Exception {
        assertEquals(statementsController.getFileAsString("src/test/resources/statements.json"), "[{\"id\":1,\"fieldInt\":5,\"fieldString\":\"test\"}]");
    }
    @Test
    public void testGetStringAsJSONObject() throws Exception{
        statements = statementsController.getFileAsString("src/test/resources/statements.json");
        assertEquals(statementsController.getStringAsJSONArray(statements).getJSONObject(0).getString("fieldString"),"test");

    }


}


