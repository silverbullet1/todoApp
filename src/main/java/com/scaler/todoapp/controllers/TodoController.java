package com.scaler.todoapp.controllers;

import com.scaler.todoapp.exceptions.TodoExceptions;
import com.scaler.todoapp.models.CustomErrorMessage;
import com.scaler.todoapp.models.TodoResponse;
import com.scaler.todoapp.exceptions.TodoNotFoundException;
import com.scaler.todoapp.models.TodoDTO;
import com.scaler.todoapp.utils.IdValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/todo")
public class TodoController {

    //Stateful controller for learning purposes
    List<TodoResponse> todoResponses = new ArrayList<>();

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    TodoResponse createTodo(@RequestBody TodoDTO todoDTO) {
        TodoResponse todoResponse = new TodoResponse(todoDTO.task, false);
        todoResponses.add(todoResponse);
        return todoResponse;
    }

    @GetMapping("")
    List<TodoResponse> getAllTodo() {
        return todoResponses;
    }

    @GetMapping("/{id}")
        TodoResponse getTodoById(@PathVariable int id) {
        //Todo add this id checking condition at some common place as "guard"
        IdValidator.assertValidId(id, todoResponses.size());
        return todoResponses.get(id-1);
    }

    @PutMapping("/{id}/done")
    TodoResponse setDone(@PathVariable int id) {
        IdValidator.assertValidId(id, todoResponses.size());
        todoResponses.get(id-1).setDone(true);
        return todoResponses.get(id-1);
    }

    @DeleteMapping("/{id}/done")
    TodoResponse undoDone(@PathVariable int id) {
        IdValidator.assertValidId(id, todoResponses.size());
        todoResponses.get(id-1).setDone(false);
        return todoResponses.get(id-1);
    }

    @ExceptionHandler
    ResponseEntity<CustomErrorMessage> handleException(TodoExceptions err){
        CustomErrorMessage CEM = new CustomErrorMessage();
        CEM.setStatus(HttpStatus.NOT_FOUND.value());
        CEM.setMessage(err.getMessage());
        return new ResponseEntity<>(CEM,HttpStatus.NOT_FOUND);
    }

}
