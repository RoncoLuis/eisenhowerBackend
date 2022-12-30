package com.eisenhower.matrix.model;

/* 
 * Note: Priority levels
 * UI - Urgent, Important (1)
 * NUI - Not Urgent, Important (2)
 * UNI - Urgent, Not Important (3)
 * NUNI - Not Urgent, Not Important (4)
 * */
public class Task {

	private Integer idTask;

	private String taskName;

	private String taskDescription;

	private boolean taskDone;

	private String priority;

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskDone=" + taskDone + ", priority=" + priority + "]";
	}

}
