package com.eisenhower.matrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/task")
@RestController
public class TaskController {

	@Autowired
	private ITaskService taskService;

	// CRUD
	// create task
	@PostMapping("/create")
	public String createTask(@ModelAttribute Task task) {
		return taskService.createTask(task);
	}

	// read task - findAll
	@GetMapping("/findAll")
	public List<Task> findAllTaskList() {
		return taskService.findAll();
	}

	// read task - findTaskById
	@GetMapping("/findById/{id}")
	public Task findTaskById(@PathVariable("id") Integer id) {
		return taskService.findTaskById(id);
	}

	// update task
	@PostMapping("/update")
	public String updateTask(@ModelAttribute Task theUpdatedTask) {
		return taskService.updateTask(theUpdatedTask);
	}

	// delete task
	@PostMapping("/delete")
	public String deleteTask(@RequestParam("id") Integer id) {
		return taskService.deleteTask(id);
	}

	// update task status
	@GetMapping("/finished/{id}")
	public String taskFinished(@PathVariable("id") Integer id) {
		return taskService.isTaskDone(id);
	}

}
