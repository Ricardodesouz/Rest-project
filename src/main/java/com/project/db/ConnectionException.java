package com.project.db;

public class ConnectionException extends RuntimeException {
    private static final Long SerialversionUID = 1L;
    public ConnectionException(String msg){
        super(msg);
    }


}
