package com.cts.projectManagement.model;

import java.util.List;

public class TaskDetailsResponse {
	
	List<ProjectDetail> projectDetails;

	public List<ProjectDetail> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetail> projectDetails) {
		this.projectDetails = projectDetails;
	}

}
