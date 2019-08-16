
package com.projectBoard.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectBoard.demo.model.ProjectTask;
import com.projectBoard.demo.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
	if (projectTask.getStatus() == null || projectTask.getStatus().isEmpty()) {
	    projectTask.setStatus("TO_DO");
	}
	return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll() {
	return projectTaskRepository.findAll();
    }
    
    public ProjectTask findByID(Long id) {
	return projectTaskRepository.getById(id);
    }
    
    public void deleteProjectTask(Long id) {
	ProjectTask projectTask = findByID(id);
	projectTaskRepository.delete(projectTask);
    }
}
