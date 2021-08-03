package com.scaler.todoapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class TodoNotFoundException extends TodoException {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
