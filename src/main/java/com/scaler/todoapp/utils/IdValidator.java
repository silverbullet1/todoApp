package com.scaler.todoapp.utils;

import com.scaler.todoapp.exceptions.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class IdValidator {
    public static boolean assertValidId(int id, int size) throws TodoNotFoundException {
        if (id <= 0 || id > size)
            throw new TodoNotFoundException("Todo not found with id = " + id);
        return true;
    }
};
