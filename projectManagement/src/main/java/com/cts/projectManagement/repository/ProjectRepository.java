package com.cts.projectManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectManagement.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	List<Project> findAll();
    Project findByProjectId(Long id);

}
