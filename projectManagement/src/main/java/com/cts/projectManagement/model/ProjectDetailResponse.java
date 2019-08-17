package com.cts.projectManagement.model;

import java.time.LocalDate;

public class ProjectDetailResponse {
	private Long projectId;
	private String project;
	private LocalDate startDate;
	private LocalDate endDate;
	private int priority;
	private int noOfTasks;
	private int noofTasksCompleted;
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
	public int getNoOfTasks() {
		return noOfTasks;
	}
	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}
	public int getNoofTasksCompleted() {
		return noofTasksCompleted;
	}
	public void setNoofTasksCompleted(int noofTasksCompleted) {
		this.noofTasksCompleted = noofTasksCompleted;
	}

}
