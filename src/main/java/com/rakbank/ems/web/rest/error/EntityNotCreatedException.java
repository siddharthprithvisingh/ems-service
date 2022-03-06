package com.rakbank.ems.web.rest.error;

public class EntityNotCreatedException extends Exception{

    public EntityNotCreatedException(String errorMessage){
        super(errorMessage);
    }

    public EntityNotCreatedException(String errorMessage, Throwable exception){
        super(errorMessage,exception);
    }
}
