package com.cts.projectManagement.repository;
import org.springframework.data.repository.CrudRepository;

import com.cts.projectManagement.entity.ParentTask;

public interface ParentTaskRepository  extends CrudRepository<ParentTask,Long>{
	ParentTask findByParentId(Long id);

}
