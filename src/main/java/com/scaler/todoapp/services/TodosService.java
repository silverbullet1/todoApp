package com.scaler.todoapp.services;

import com.scaler.todoapp.entities.TodoEntity;
import com.scaler.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodosService {
    TodoRepository todoRepository;

    public TodosService(TodoRepository tasksRepository) {
        this.todoRepository = tasksRepository;
    }

    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoEntity getTodoById(int id) {
        return todoRepository.getById(id-1);
    }

    public TodoEntity createTodo(String name) {
        TodoEntity todoEntity = TodoEntity.builder().task(name).status(false).build();
        todoRepository.save(todoEntity);
        return todoEntity; 
    }

    public TodoEntity setTodoStatus(int id, boolean status) {
        var task = todoRepository.getById(id-1);
        task.setStatus(status);
        return todoRepository.save(task);
    }

}
