package com.cts.projectManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "PARENTTASK")
public class ParentTask implements Serializable {
	
	private static final long serialVersionUID = -2532681393360264413L;

	@Id
	@Column(name="PARENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentId;
	
	@Column(name="PARENT_TASK")
	private String parentTask;
	
	/*
	 * @OneToOne(mappedBy="parentTask") private Task task;
	 * 
	 * public Task getTask() { return task; }
	 * 
	 * public void setTask(Task task) { this.task = task; }
	 */
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	
	

}
