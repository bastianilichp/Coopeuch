package com.coopeuch.coopeuch.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TaskExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public TaskExceptions (String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
