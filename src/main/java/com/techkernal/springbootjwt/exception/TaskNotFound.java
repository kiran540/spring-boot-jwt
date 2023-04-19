package com.techkernal.springbootjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFound extends Exception{
    private String message;
    public TaskNotFound(String message) {
        super(message);
        this.message = message;
    }
}
