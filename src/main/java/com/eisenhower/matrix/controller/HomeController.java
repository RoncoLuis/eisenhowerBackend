package com.eisenhower.matrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;

@Controller
public class HomeController {
	private String thePageTitle = "MHeinsenhower";
	private String theAutor = "Luis Ronquillo";
	@Autowired
	ITaskService taskService;
	
	@GetMapping("/")
	public String home(Model theModel) {
		theModel.addAttribute("thePageTitle",thePageTitle);
		theModel.addAttribute("theAutor",theAutor);
		
		//passing the list of tasklist
		theModel.addAttribute("taskList", taskService.findAll());
		
		return "home";
	}
	
	@GetMapping("/tasks/form/new")
	public String createNewPage(Model theModel) {
		theModel.addAttribute("thePageTitle",thePageTitle);
		theModel.addAttribute("theAutor",theAutor);
		
		return "tasks/createnew-form";
	}
	
	@PostMapping("/tasks/form/new/save")
	public String newTask(Task theNewtask) {
		theNewtask.setIdTask(autoIncrementTaskId());
		taskService.createTask(theNewtask);
		return "redirect:/";
	}
	
	// update task
	@GetMapping("/update/{id}")
	public String updateTask(@PathVariable("id") Integer id, Model theModel) {
		Task taskToBeUpdated = taskService.findTaskById(id);
		theModel.addAttribute("taskToBeUpdated",taskToBeUpdated);
		return "tasks/update-task-form";
	}
	
	//service to simulate the task id auto_increment
	public int autoIncrementTaskId() {
		//current size of the task list
		int currentSize = taskService.findAll().size();
		return currentSize+1;
	}
	
	
}
