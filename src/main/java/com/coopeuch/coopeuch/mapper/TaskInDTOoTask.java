package com.coopeuch.coopeuch.mapper;

import com.coopeuch.coopeuch.persistence.entity.Task;
import com.coopeuch.coopeuch.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;


import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Component
public class TaskInDTOoTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in ){
        Task task = new Task();
        task.setDescripcion(in.getDescripcion());
        task.setFechaCreacion(new Date());
        task.setVigente(in.getVigente());
        return task;

    }

}
