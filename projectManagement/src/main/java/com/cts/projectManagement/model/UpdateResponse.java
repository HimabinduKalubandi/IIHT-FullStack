package com.cts.projectManagement.model;

public class UpdateResponse {
	
	private boolean updateIndicator;

	public UpdateResponse(boolean updateIndicator) {
		super();
		this.updateIndicator = updateIndicator;
	}

	public boolean isUpdateIndicator() {
		return updateIndicator;
	}

	public void setUpdateIndicator(boolean updateIndicator) {
		this.updateIndicator = updateIndicator;
	}

}
