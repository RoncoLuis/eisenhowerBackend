package com.eisenhower.matrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;
import com.eisenhower.matrix.util.Constants;

@Controller
public class HomeController {

	@Autowired
	ITaskService taskService;

	@GetMapping("/")
	public String home(Model theModel) {
		theModel.addAttribute("thePageTitle", Constants.thePageTitle);
		theModel.addAttribute("theAutor", Constants.thePageAutor);
		theModel.addAttribute("taskList", taskService.findAll());// passing tasklist to model

		return Constants.HOME;
	}

	@GetMapping("/createnew")
	public String createNewPage(Model theModel) {
		theModel.addAttribute("thePageTitle", Constants.thePageTitle);
		theModel.addAttribute("theAutor", Constants.thePageAutor);

		return Constants.CREATE_NEW_TASK_FORM;
	}

	//route to edit task
	@GetMapping("/update/{id}")
	public String updateTaskPage(@PathVariable("id") Integer id, Model theModel) {
		Task taskToBeUpdated = taskService.findTaskById(id);
		System.out.println("Found object:"+ taskToBeUpdated.toString());
		theModel.addAttribute("taskToBeUpdated", taskToBeUpdated);

		return Constants.UPDATE_TASK_FORM;
	}

}
