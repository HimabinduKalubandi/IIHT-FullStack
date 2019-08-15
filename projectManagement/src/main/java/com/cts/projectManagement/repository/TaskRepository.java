package com.cts.projectManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.projectManagement.entity.Task;


public interface TaskRepository  extends CrudRepository<Task,Long>{
	List<Task> findAll();
	Task findByTaskId(Long id);

}
