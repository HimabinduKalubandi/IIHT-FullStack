package com.cts.projectManagement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.projectManagement.entity.ParentTask;
import com.cts.projectManagement.entity.Project;
import com.cts.projectManagement.entity.Task;
import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.repository.ParentTaskRepository;
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
	@Autowired
	ParentTaskRepository parentTaskRepository;

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
			logger.error("An error occured while saving the task", e);
			return false;
		}
		return true;
	}
	
	public boolean saveParentTask(ParentTask task) {
		try {
			parentTaskRepository.save(task);
		} catch (Exception e) {
			logger.error("An error occured while saving the parent task", e);
			return false;
		}
		return true;
	}

	public Project getProjectById(Long id) {
		Project project= null;
		try {
			project= projectRepository.findByProjectId(id);
		}catch (Exception e) {
			logger.error("An error occured while retrieving the project", e);
		}
		
		return project;


	}
	
	public List<Project> getProjects() {
		List<Project> projects = null;
		try {
			projects= projectRepository.findAll();
		}catch (Exception e) {
			logger.error("An error occured while retrieving the projects", e);
		}
		
		return projects;


	}
	
	public ParentTask getParentTaskById(Long id) {
		ParentTask parentTask= null;
		try {
			parentTask= parentTaskRepository.findByParentId(id);
		}catch (Exception e) {
			logger.error("An error occured while retrieving the project", e);
			System.out.println(e);
		}
		
		return parentTask;


	}
}
