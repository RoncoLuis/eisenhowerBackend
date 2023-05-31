package com.eisenhower.matrix.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;

//@CrossOrigin(origins = { "http://localhost:4200" })
//@RestController
@RequestMapping("/task")
@Controller
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@PostMapping("/save")
	public String newTask(@ModelAttribute Task theNewtask) {
		theNewtask.setIdTask(autoIncrementTaskId());
		if(theNewtask.getTaskDescription() == ""){
			theNewtask.setTaskDescription("-- No comments added --");
		}
		taskService.createTask(theNewtask);
		return "redirect:/";
	}

	@PostMapping("/update/{id}")
	//@RequestParam(name = "id") int idVacante
	public String updatedTask(@PathVariable("id") String taskId,
							  @ModelAttribute Task theUpdatedTask, Model theModel) {
		theUpdatedTask.setIdTask(Integer.parseInt(taskId));
		taskService.updateTask(theUpdatedTask);
		theModel.addAttribute("taskList", taskService.findAll());
		return "redirect:/";
	}

	// read task - findTaskById
	@GetMapping("/findById/{id}")
	public Task findTaskById(@PathVariable("id") Integer id) {
		return taskService.findTaskById(id);
	}

	// delete task
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") Integer id) {

		taskService.deleteTask(id);
		return "redirect:/";
	}

	// update task status
	@GetMapping("/finished/{id}")
	public String taskFinished(@PathVariable("id") Integer id) {
		taskService.isTaskDone(id);
		return "redirect:/";
	}

	// service to simulate the task id auto_increment
	public int autoIncrementTaskId() {
		// current size of the task list
		int currentSize = taskService.findAll().size();
		return currentSize + 1;
	}

}
