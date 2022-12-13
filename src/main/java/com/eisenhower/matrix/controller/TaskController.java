package com.eisenhower.matrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;

@CrossOrigin(origins = { "http://localhost:4200" })
//@Controller
@RestController
public class TaskController {

	@Autowired
	private ITaskService taskService;
	
	//save task
	@PostMapping("/save")
	public String createTask(@ModelAttribute Task task) {
		return taskService.createTask(task);
	}
	
	//get tasklist
	@GetMapping("/task/getList")
	public List<Task> getTaskList() {
		return taskService.getTaskList();
	}
	
	//find task by id
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable("id") int id) {
		return taskService.findTaskById(id);
	}
	
	
	
	
	
	
	
	
	
	
}
