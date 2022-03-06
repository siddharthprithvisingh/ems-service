package com.rakbank.ems.web.rest.error.handler;

import com.rakbank.ems.web.rest.error.EntityNotCreatedException;
import com.rakbank.ems.web.rest.error.EntityNotFoundException;
import com.rakbank.ems.web.rest.error.EntityNotUpdatedException;
import com.rakbank.ems.web.rest.error.NoRecordsFoundException;
import com.rakbank.ems.web.rest.response.GenericObjectResponse;
import com.rakbank.ems.web.rest.response.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ResourceBundle;

@RestControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class) ;

    private ResourceBundle errorMessageBundle = ResourceBundle.getBundle("errorMessages") ;

    @ExceptionHandler({EntityNotCreatedException.class})
    ResponseEntity<GenericObjectResponse<String>> entityNotCreatedException(EntityNotCreatedException exception){
        String errorCode = exception.getMessage() ;
        String errorMessage = errorMessageBundle.getString(errorCode) ;
        logger.error("EntityNotCreatedException: " + errorMessage, exception) ;
        ResponseObject responseObject = new ResponseObject(errorCode,errorMessage) ;
        GenericObjectResponse finalResponse = new GenericObjectResponse(null,responseObject);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(finalResponse) ;
    }

    @ExceptionHandler({EntityNotUpdatedException.class})
    ResponseEntity<GenericObjectResponse<String>> entityNotUpdatedException(EntityNotUpdatedException exception){
        String errorCode = exception.getMessage() ;
        String errorMessage = errorMessageBundle.getString(errorCode) ;
        logger.error("EntityNotUpdatedException: " + errorMessage, exception) ;
        ResponseObject responseObject = new ResponseObject(errorCode,errorMessage) ;
        GenericObjectResponse finalResponse = new GenericObjectResponse(null,responseObject);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(finalResponse) ;
    }

    @ExceptionHandler({EntityNotFoundException.class})
    ResponseEntity<GenericObjectResponse<String>> entityNotFoundException(EntityNotFoundException exception){
        String errorCode = exception.getMessage() ;
        String errorMessage = errorMessageBundle.getString(errorCode) ;
        logger.error("EntityNotFoundException: " + errorMessage, exception) ;
        ResponseObject responseObject = new ResponseObject(errorCode,errorMessage) ;
        GenericObjectResponse finalResponse = new GenericObjectResponse(null,responseObject);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(finalResponse) ;
    }

    @ExceptionHandler({NoRecordsFoundException.class})
    ResponseEntity<GenericObjectResponse<String>> noRecordsFoundException(NoRecordsFoundException exception){
        String errorCode = exception.getMessage() ;
        String errorMessage = errorMessageBundle.getString(errorCode) ;
        logger.error("NoRecordsFoundException: " + errorMessage, exception) ;
        ResponseObject responseObject = new ResponseObject(errorCode,errorMessage) ;
        GenericObjectResponse finalResponse = new GenericObjectResponse(null,responseObject);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(finalResponse) ;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorCode = "ValidationError" ;
        String errorMessage = exception.getFieldError().getDefaultMessage() ;
        logger.error("MethodArgumentNotValidException: " + errorMessage, exception) ;
        ResponseObject responseObject = new ResponseObject(errorCode,errorMessage) ;
        GenericObjectResponse finalResponse = new GenericObjectResponse(null,responseObject);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(finalResponse) ;
    }
}
