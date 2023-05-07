package com.coopeuch.coopeuch.service.dto;

import lombok.Data;


import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TaskInDTO {

    private String descripcion;
    private Date fechaCreacion;
    private Boolean vigente;
}
