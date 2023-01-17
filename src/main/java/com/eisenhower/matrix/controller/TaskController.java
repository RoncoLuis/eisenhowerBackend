package com.eisenhower.matrix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;
import com.eisenhower.matrix.util.Constants;

@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/task")
//@RestController
@Controller
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@PostMapping("/save")
	public String newTask(@ModelAttribute Task theNewtask) {
		theNewtask.setIdTask(autoIncrementTaskId());
		taskService.createTask(theNewtask);
		return "redirect:/";
	}

	@GetMapping("/update")
	//@RequestParam(name = "id") int idVacante
	public String updatedTask(@ModelAttribute Task theUpdatedTask) {
		System.out.println(theUpdatedTask.getIdTask());
		taskService.updateTask(theUpdatedTask);
		return "redirect:/";
	}

	// read task - findTaskById
	@GetMapping("/findById/{id}")
	public Task findTaskById(@PathVariable("id") Integer id) {
		return taskService.findTaskById(id);
	}

	/*
	 * // update task
	 * 
	 * @PostMapping("/update") public String updateTask(@ModelAttribute Task
	 * theUpdatedTask) { return taskService.updateTask(theUpdatedTask); }
	 */
	
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

	// service to simulate the task id auto_increment
	public int autoIncrementTaskId() {
		// current size of the task list
		int currentSize = taskService.findAll().size();
		return currentSize + 1;
	}

}
