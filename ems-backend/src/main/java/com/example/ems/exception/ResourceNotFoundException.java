package com.example.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    //CREATING A PARAMETERISED constructor
    public ResourceNotFoundException(String message){
        super(message);
    }

}
