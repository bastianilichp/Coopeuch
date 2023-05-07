package com.coopeuch.coopeuch.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripcion;
    @Column
    private Date fechaCreacion;
    @Column
    private Boolean vigente;

}
