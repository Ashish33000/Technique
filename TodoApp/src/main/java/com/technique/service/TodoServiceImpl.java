package com.technique.service;

import com.technique.exception.TodoException;
import com.technique.model.Task;
import com.technique.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepo repo;
    @Override
    public Task addTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        return repo.save(task);
    }

    @Override
    public List<Task> findAllTask() throws TodoException {
        List<Task> list=repo.findAll();
        if(list.isEmpty()){
            throw  new TodoException("No todo is registered");
        }
        return list;
    }

    @Override
    public Task getTaskById(Integer id) throws TodoException {
        Optional<Task> opt=repo.findById(id);
        if(opt.isPresent()){
            Task task=opt.get();
            return task;
        }else{
            throw  new TodoException("No tsk is present with this id"+id);
        }

    }

    @Override
    public Task updateTaskById(Task task,Integer id) throws TodoException {
        Optional<Task> opt=repo.findById(id);
        if(opt.isPresent()){
            Task existing=opt.get();
            existing.setDescription(task.getDescription());
            existing.setTitle(task.getTitle());
            existing.setCreationDate(task.getCreationDate());
            existing.setStatus(task.isStatus());
            return existing;
        }else{
            throw  new TodoException("No tsk is present with this id"+id);
        }

    }

    @Override
    public Task deleteTaskById(Integer id) throws TodoException {
        Optional<Task> opt=repo.findById(id);
        if(opt.isPresent()){
            Task task=opt.get();
            repo.delete(task);
            return task;
        }else{
            throw  new TodoException("No tsk is present with this id"+id);
        }
    }
}
