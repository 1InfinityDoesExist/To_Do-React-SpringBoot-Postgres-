package com.projectBoard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectBoard.demo.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    @Query("Select ProjectTask from #{#entityName} ProjectTask where id=?1")
    public ProjectTask getById(Long id);
}
