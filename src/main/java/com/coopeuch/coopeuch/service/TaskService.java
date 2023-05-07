package com.coopeuch.coopeuch.service;

import com.coopeuch.coopeuch.exceptions.TaskExceptions;
import com.coopeuch.coopeuch.mapper.TaskInDTOoTask;
import com.coopeuch.coopeuch.persistence.entity.Task;
import com.coopeuch.coopeuch.persistence.repository.TaskRepository;

import com.coopeuch.coopeuch.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOoTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOoTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask (TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
       return this.repository.save(task);
    }
    public List<Task> findAll(){
        return this.repository.findAll();

    }
    @Transactional
    public void updateTask(Long id, String descripcion, Boolean vigente){
        Optional<Task> optionalTask =  this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new TaskExceptions( "Tarea no encontrada" , HttpStatus.NOT_FOUND);
        }
        this.repository.updateTask(id,descripcion, vigente);

    }
    @Transactional
    public void deleteById(Long id){
        Optional<Task> optionalTask =  this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new TaskExceptions( "Tarea no encontrada" , HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);

    }



}
