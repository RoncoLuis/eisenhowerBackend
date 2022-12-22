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
	public List<Task> findAll() {
		return taskList;
	}

	// read (find by id)
	@Override
	public Task findTaskById(Integer id) {
		List<Task> tempList = findAll();
		for (Task task : tempList) {
			if (task.getIdTask() == id) {
				return task;
			}
		}
		return null;
	}

	// update
	@Override
	public String updateTask(Task theUpdatedTask) {
		int aux = 0;
		for (Task temp : taskList) {
			if (temp.getIdTask() == theUpdatedTask.getIdTask()) {
				taskList.set(aux, theUpdatedTask);
				return "task updated";
			}
			aux++;
		}

		return null;
	}
	
	@Override
	public String isTaskDone(Integer theTaskId) {
		int aux = 0;
		for(Task temporalTask : taskList) {
			if(temporalTask.getIdTask() == theTaskId) {
				Task tempTask = taskList.get(aux);
				tempTask.setTaskDone(true);
				return updateTask(tempTask);
			}
			aux++;
		}
		return null;
	}

	// delete
	@Override
	public String deleteTask(Integer id) {
		int aux = 0;
		for (Task temp : taskList) {
			if (temp.getIdTask() == id) {
				taskList.remove(aux);
				return "Task deleted";
			}
			aux++;
		}
		return null;
	}

}
