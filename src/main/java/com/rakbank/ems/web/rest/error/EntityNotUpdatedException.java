package com.rakbank.ems.web.rest.error;

public class EntityNotUpdatedException extends Exception{

    public EntityNotUpdatedException(String errorMessage){
        super(errorMessage);
    }

    public EntityNotUpdatedException(String errorMessage, Throwable exception){
        super(errorMessage,exception);
    }
}
