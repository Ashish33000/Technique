package com.technique.controller;

import com.technique.exception.TodoException;
import com.technique.model.Task;
import com.technique.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired

    private TodoService service;
     @PostMapping
     @ResponseStatus(code = HttpStatus.CREATED)
    public Task addTaskHandler(@RequestBody Task task){
        return service.addTask(task);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> findAllTaskHandler(){
        return service.findAllTask();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task getTaskByIdHandler(@PathVariable Integer id){
        return service.getTaskById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task updateTaskByIdHandler(@RequestBody Task task,@PathVariable Integer id){
        return service.updateTaskById(task,id);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Task deleteTaskByIdHandler(@PathVariable Integer id){
        return service.deleteTaskById(id);
    }
}
