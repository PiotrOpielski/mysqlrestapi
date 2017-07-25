package com.mysqlapi.exception;


public class StatementNotFoundException extends Exception {
    public StatementNotFoundException(String statement) {
        super(statement);
    }
}
