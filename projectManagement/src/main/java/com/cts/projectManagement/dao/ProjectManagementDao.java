package com.cts.projectManagement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.projectManagement.entity.Project;
import com.cts.projectManagement.entity.Task;
import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.repository.ProjectRepository;
import com.cts.projectManagement.repository.TaskRepository;
import com.cts.projectManagement.repository.UserRepository;

@Component
public class ProjectManagementDao {
	public final static Logger logger = LoggerFactory.getLogger(ProjectManagementDao.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskRepository taskRepository;

	public boolean saveUser(User user) {
		try {
			userRepository.save(user);
		} catch (Exception e) {
			logger.error("An error occured while saving the user", e);
			return false;
		}
		return true;

	}

	public List<User> getUsers() {
		List<User> users = null;
		try {

			users = userRepository.findAll();

		} catch (Exception e) {
			logger.error("An error occured while retrieving the user", e);
		}

		return users;

	}
	
	public User getUserById(Long id) {
		User user= null;
		try {
			user= userRepository.findByUserId(id);
		}catch (Exception e) {
			logger.error("An error occured while retrieving the user", e);
		}
		
		return user;
		
	}

	public boolean saveProject(Project project) {
		try {
			projectRepository.save(project);
		} catch (Exception e) {
			logger.error("An error occured while saving the project", e);
			return false;
		}
		return true;
	}
	
	public boolean saveTask(Task task) {
		try {
			taskRepository.save(task);
		} catch (Exception e) {
			logger.error("An error occured while saving the project", e);
			return false;
		}
		return true;
	}

	public Project getProjectById(Long id) {
		Project project= null;
		try {
			project= projectRepository.findByProjectId(id);
		}catch (Exception e) {
			logger.error("An error occured while retrieving the user", e);
		}
		
		return project;


	}
}
