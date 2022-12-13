package com.eisenhower.matrix.model;

public class Task {
	private int idTask;
	private String taskName;
	private String taskDescription;
	private boolean taskDone;

	// empty constructor
	public Task() {
		super();
	}

	// all arguments constructor
	public Task(int idTask, String taskName, String taskDescription, boolean taskDone) {
		super();
		this.idTask = idTask;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDone = taskDone;
	}

	// no idTask constructor
	public Task(String taskName, String taskDescription, boolean taskDone) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskDone = taskDone;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public boolean isTaskDone() {
		return taskDone;
	}

	public void setTaskDone(boolean taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskDone=" + taskDone + "]";
	}

}
