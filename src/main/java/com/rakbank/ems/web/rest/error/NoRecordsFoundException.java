package com.rakbank.ems.web.rest.error;

public class NoRecordsFoundException extends Exception{

    public NoRecordsFoundException(String errorMessage){
        super(errorMessage);
    }

    public NoRecordsFoundException(String errorMessage, Throwable exception){
        super(errorMessage,exception);
    }
}
