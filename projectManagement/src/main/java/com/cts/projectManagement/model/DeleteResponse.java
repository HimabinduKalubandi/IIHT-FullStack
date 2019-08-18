package com.cts.projectManagement.model;

public class DeleteResponse {
	private boolean deleteIndicator;

	

	public DeleteResponse(boolean deleteIndicator) {
		super();
		this.deleteIndicator = deleteIndicator;
	}

	public boolean isDeleteIndicator() {
		return deleteIndicator;
	}

	public void setDeleteIndicator(boolean deleteIndicator) {
		this.deleteIndicator = deleteIndicator;
	}

}
