package com.eisenhower.matrix.services;

import java.util.List;

import com.eisenhower.matrix.model.Task;

public interface ITaskService {

	//service to create,read, update and delete tasks
	
	//create service
	public String createTask(Task task);
	
	//update service
	public String updateTask();
	
	//read task service (find all)
	public List<Task> getTaskList();
	
	//read taskList (find by id)
	public Task findTaskById(Integer id);
	
	//delete service
	public String deleteTask();
}
