package com.cts.projectManagement.model;

public class AddParentTaskRequest {
	private Long parentTaskId;
	public AddParentTaskRequest(Long parentTaskId, String parentTask) {
		super();
		this.parentTaskId = parentTaskId;
		this.parentTask = parentTask;
	}
	private String parentTask;
	public Long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
