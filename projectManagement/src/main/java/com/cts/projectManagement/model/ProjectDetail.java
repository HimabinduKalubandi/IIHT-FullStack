package com.cts.projectManagement.model;

import java.time.LocalDate;
import java.util.List;

public class ProjectDetail {
	
	private Long projectId;
	private String project;
	private LocalDate startDate;
	private LocalDate endDate;
	private int priority;
	private List<TaskDetail> TaskDetails;
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public List<TaskDetail> getTaskDetails() {
		return TaskDetails;
	}
	public void setTaskDetails(List<TaskDetail> taskDetails) {
		TaskDetails = taskDetails;
	}

}
