package com.coopeuch.coopeuch.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "TASK", schema = "BASTIAN")
@SequenceGenerator(name = "SEQ_TASK", schema = "BASTIAN", sequenceName = "SEQ_TASK", allocationSize = 1)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TASK")
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "VIGENTE")
    private Boolean vigente;

}
