package com.technique.service;

import com.technique.exception.TodoException;
import com.technique.model.Task;

import java.util.List;

public interface TodoService {
    public Task addTask(Task task);
    public List<Task> findAllTask()throws TodoException;
    public Task getTaskById(Integer id)throws TodoException;
    public Task updateTaskById(Task task,Integer id)throws TodoException;
    public Task deleteTaskById(Integer id)throws TodoException;
}
