package com.coopeuch.coopeuch.service;

import com.coopeuch.coopeuch.persistence.entity.Task;
import com.coopeuch.coopeuch.persistence.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        task = new Task();
        task.setDescripcion("test");
        task.setVigente(true);
        task.setFechaCreacion(LocalDateTime.now());
        task.setId(new Long (1));

    }


    @Test
    void findAll() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));
        assertNotNull(taskService.findAll());
    }



}