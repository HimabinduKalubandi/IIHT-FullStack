package com.cts.projectManagement.model;

public class AddTaskResponse {
	private boolean addIndicator;

	public AddTaskResponse(boolean addIndicator) {
		super();
		this.addIndicator = addIndicator;
	}

	public boolean isAddIndicator() {
		return addIndicator;
	}

	public void setAddIndicator(boolean addIndicator) {
		this.addIndicator = addIndicator;
	}

}
