package com.projectBoard.demo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectBoard.demo.model.ProjectTask;
import com.projectBoard.demo.model.common.BaseEntity;
import com.projectBoard.demo.service.ProjectTaskService;
import com.projectBoard.demo.util.ReflectionUtil;

@RestController
@RequestMapping(path = "/api/board")
@CrossOrigin
public class ProjectTaskController extends BaseEntity{
    @Autowired
    private ProjectTaskService projectTaskService;

    ReflectionUtil refUtil = ReflectionUtil.getInstance();

    @PostMapping(path = "")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {

	if (result.hasErrors()) {
	    Map<String, String> errorMap = new HashMap<String, String>();
	    for (FieldError error : result.getFieldErrors()) {
		errorMap.put(error.getField(), error.getDefaultMessage());
	    }
	    return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
	ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

	return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public Iterable<ProjectTask> getAllPTs() {
	return projectTaskService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPTById(@PathVariable Long id) {
	ProjectTask projectTask = projectTaskService.findByID(id);
	return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long id) {
	projectTaskService.deleteProjectTask(id);

	return new ResponseEntity<String>("Project Task Deleted", HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> updateProjectTask(@Valid @RequestBody String projectTask,
	    @PathVariable(value = "id") Long id) throws IllegalAccessException, InvocationTargetException,
	    JSONException, org.json.simple.parser.ParseException {

	ProjectTask pt = projectTaskService.findByID(id);
	if (pt == null) {
	    return new ResponseEntity<String>("ProjectTaskt with id" + id + "Not Found", HttpStatus.OK);
	}

	JSONParser parser = new JSONParser();

	JSONObject projectTaskObject = (JSONObject) parser.parse(projectTask);
	for (Iterator iterator = ((Map<String, String>) projectTaskObject).keySet().iterator(); iterator.hasNext();) {
	    String propName = (String) iterator.next();
	    try {
		refUtil.getSetterMethod("ProjectTask", propName).invoke(pt, projectTaskObject.get(propName));
	    } catch (IllegalArgumentException e) {

	    }
	}
	projectTaskService.saveOrUpdateProjectTask(pt);
	return new ResponseEntity<ProjectTask>(pt, HttpStatus.OK);
    }

}
