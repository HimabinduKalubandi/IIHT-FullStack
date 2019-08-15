package com.cts.projectManagement.model;

public class AddUserResponse {
	
	private boolean addIndicator;

	public AddUserResponse(boolean addIndicator) {
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
