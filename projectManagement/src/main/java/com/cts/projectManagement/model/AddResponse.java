package com.cts.projectManagement.model;

public class AddResponse {
	private boolean addIndicator;

	public AddResponse(boolean addIndicator) {
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
