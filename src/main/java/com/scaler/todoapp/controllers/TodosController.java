package com.scaler.todoapp.controllers;

import com.scaler.todoapp.entities.TodoEntity;
import com.scaler.todoapp.exceptions.TodoException;
import com.scaler.todoapp.models.CustomErrorMessage;
import com.scaler.todoapp.models.TodoResponse;
import com.scaler.todoapp.models.TodoDTO;
import com.scaler.todoapp.services.TodosService;
import com.scaler.todoapp.utils.IdValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodosController {

    //Stateful controller for learning purposes
    //List<TodoResponse> todoResponses = new ArrayList<>();
//    @Autowired
    TodosService todosService;

//    public TodosController(TodosService todosService) {
//        this.todosService = todosService;
//    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public TodoEntity createTodo(@RequestBody TodoDTO todoDTO) {
       return todosService.createTodo(todoDTO.task);
    }

    @GetMapping("")
    List<TodoEntity> getAllTodo() {
        return todosService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoEntity getTodoById(@PathVariable int id) {
        //Todo add this id checking condition at some common place as "guard"
        return todosService.getTodoById(id);
    }

    @PutMapping("/{id}/done")
    TodoEntity setDone(@PathVariable int id) {
        return todosService.setTodoStatus(id, true);
    }

    @DeleteMapping("/{id}/done")
    TodoEntity undoDone(@PathVariable int id) {
        return todosService.setTodoStatus(id, false);
    }

    @ExceptionHandler
    ResponseEntity<CustomErrorMessage> handleException(TodoException err){
        CustomErrorMessage CEM = new CustomErrorMessage();
        CEM.setStatus(HttpStatus.NOT_FOUND.value());
        CEM.setMessage(err.getMessage());
        return new ResponseEntity<>(CEM,HttpStatus.NOT_FOUND);
    }

}
