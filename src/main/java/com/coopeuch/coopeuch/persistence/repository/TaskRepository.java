package com.coopeuch.coopeuch.persistence.repository;

import com.coopeuch.coopeuch.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query(value="UPDATE SET TASK DESCRIPCION  = :descripcion , VIGENTE = :vigente WHERE ID = :id ", nativeQuery = true)
    public void updateTask(@Param("id") Long id, @Param("descripcion") String descripcion ,@Param("vigente") Boolean vigente);



}

