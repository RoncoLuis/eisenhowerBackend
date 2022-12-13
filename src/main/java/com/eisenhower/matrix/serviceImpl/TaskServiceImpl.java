package com.eisenhower.matrix.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.services.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService {

	private List<Task> taskList = new ArrayList<>();

	// create
	@Override
	public String createTask(Task task) {
		System.out.println("this is your task:" + task.toString());
		taskList.add(task);
		return "Tarea agregada a la lista";
	}

	// read (find all)
	@Override
	public List<Task> getTaskList() {
		return taskList;
	}

	// read (find by id)
	@Override
	public Task findTaskById(Integer id) {
		List<Task> tempList = getTaskList();
		for (Task task : tempList) {
			if (task.getIdTask() == id) {
				return task;
			}
		}
		return null;
	}

	// update
	@Override
	public String updateTask() {
		// TODO Auto-generated method stub
		return null;
	}

	// delete
	@Override
	public String deleteTask() {
		// TODO Auto-generated method stub
		return null;
	}

}
