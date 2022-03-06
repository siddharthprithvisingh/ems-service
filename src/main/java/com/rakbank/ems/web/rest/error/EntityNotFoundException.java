package com.rakbank.ems.web.rest.error;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String errorMessage){
        super(errorMessage);
    }

    public EntityNotFoundException(String errorMessage, Throwable exception){
        super(errorMessage,exception);
    }
}
