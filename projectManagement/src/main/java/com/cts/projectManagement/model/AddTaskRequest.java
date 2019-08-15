package com.cts.projectManagement.model;

public class AddTaskRequest {
	
	private Long taskId;
	private Long parentId;
	private Long userId;
	private String task;
	private Long projectId;
	private int priority;
	private String status;
	private String startDate;
	private String endDate;
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public AddTaskRequest(Long taskId, Long parentId, Long userId, String task, Long projectId, int priority,
			String status, String startDate, String endDate) {
		super();
		this.taskId = taskId;
		this.parentId = parentId;
		this.userId = userId;
		this.task = task;
		this.projectId = projectId;
		this.priority = priority;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	

}
