package com.coopeuch.coopeuch.controller;


import com.coopeuch.coopeuch.persistence.entity.Task;
import com.coopeuch.coopeuch.persistence.repository.TaskRepository;
import com.coopeuch.coopeuch.service.TaskService;
import com.coopeuch.coopeuch.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;

    public TaskController (TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task createrTask (@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }
    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @PatchMapping("/updateTaks/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskRepository.findById(id).get();
        updatedTask.setDescripcion(task.getDescripcion());
        updatedTask.setVigente(task.getVigente());
        taskRepository.save(updatedTask);
        return "Updated Task";

    }

    @DeleteMapping("/deleteTaks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
