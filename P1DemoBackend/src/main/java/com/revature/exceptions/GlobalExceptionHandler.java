package com.revature.exceptions;


//We can use a global exception handler to clean up our code
//Would you rather:
//  Have a try/catch in every single controller for the exceptions thrown in service?
//  OR: have clean controllers and handle all exception stuff here?
//probably the second option


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //This lets our handler intercept exceptions thrown in any controller
public class GlobalExceptionHandler {
    //In here, we can define how we want to handle any Exception that could possibly be thrown

    //Right now we only have illegalargumentexception being thrown
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        //bad request is 400 status code
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

        //401 == UNAUTHORIZED - good for auth errors
        //we send the message in the exception in the response body (should change based oin what went wrong)
        //TODO: add more exception handlers, make some custom exceptions
        //TODO: add a catchall handler for "Exception"
    }

}
