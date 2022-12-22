package com.eisenhower.matrix.services;

import java.util.List;

import com.eisenhower.matrix.model.Task;

public interface ITaskService {

	//service to create,read, update and delete tasks
	
	//create task
	public String createTask(Task task);
	
	//read task service (find all)
	public List<Task> findAll();
	
	//read taskList (find by id)
	public Task findTaskById(Integer id);
		
	//update service
	public String updateTask(Task task);
	
	//delete service
	public String deleteTask(Integer id);
	
	//finished task
	public String isTaskDone(Integer theTaskId);
}
