package com.cts.projectManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.projectManagement.dao.ProjectManagementDao;
import com.cts.projectManagement.entity.ParentTask;
import com.cts.projectManagement.entity.Project;
import com.cts.projectManagement.entity.Task;
import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.mapper.ProjectManagementMapper;
import com.cts.projectManagement.model.AddParentTaskRequest;
import com.cts.projectManagement.model.AddProjectrequest;
import com.cts.projectManagement.model.AddResponse;
import com.cts.projectManagement.model.AddTaskRequest;
import com.cts.projectManagement.model.AddUserRequest;
import com.cts.projectManagement.model.ProjectDetail;
import com.cts.projectManagement.model.ProjectDetailResponse;
import com.cts.projectManagement.model.ProjectsList;
import com.cts.projectManagement.model.TaskDetailsResponse;
import com.cts.projectManagement.model.UserDetail;
import com.cts.projectManagement.model.UserDetailsResponse;
import com.cts.projectManagement.utils.DateUtils;

@Controller
public class ProjectManagementController {
	@Autowired
	ProjectManagementDao projectManagementDao;

	@Autowired
	ProjectManagementMapper mapper;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	public ResponseEntity<AddResponse> addUser(@RequestBody AddUserRequest userRequest) {
		User user = new User();

		user.setEmployeeId(userRequest.getEmployeeId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		AddResponse response = new AddResponse(projectManagementDao.saveUser(user));
		return new ResponseEntity<AddResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<UserDetail> getUserById(@PathVariable("id") Long userId) {
		User user = projectManagementDao.getUserById(userId);
		UserDetail response = new UserDetail();
		response.setEmployeeId(user.getEmployeeId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setUserId(user.getUserId());
		return new ResponseEntity<UserDetail>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<UserDetailsResponse> getUsers() {
		List<User> users = projectManagementDao.getUsers();
		UserDetailsResponse response = mapper.mapUserResponse(users);
		return new ResponseEntity<UserDetailsResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	public ResponseEntity<AddResponse> addProject(@RequestBody AddProjectrequest request) {
		Project project = new Project();

		project.setProjectId(request.getProjectId());
		project.setDate(DateUtils.toLocalDate(request.getStartDate()));
		project.setEndDate(DateUtils.toLocalDate(request.getEndDate()));
		project.setProject(request.getProject());
		project.setPriority(request.getPriority());
		project.setUser(projectManagementDao.getUserById(request.getUserId()));
		AddResponse response = new AddResponse(projectManagementDao.saveProject(project));
		return new ResponseEntity<AddResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<ProjectDetail> getProjectById(@PathVariable("id") Long projectId) {
		Project project = projectManagementDao.getProjectById(projectId);
		ProjectDetail response = mapper.mapProjectResponse(project);

		return new ResponseEntity<ProjectDetail>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/task", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<TaskDetailsResponse> getTasks() {
		List<Project> projects = projectManagementDao.getProjects();
		TaskDetailsResponse response = mapper.mapTaskResponse(projects);
		return new ResponseEntity<TaskDetailsResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET, produces = "application/json")

	public ResponseEntity<ProjectsList> getProjects() {
		List<Project> projects = projectManagementDao.getProjects();
		ProjectsList response = mapper.mapProjectResponse(projects);
		return new ResponseEntity<ProjectsList>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	public ResponseEntity<AddResponse> addTask(@RequestBody AddTaskRequest request) {
		Task task = new Task();

		task.setProject(projectManagementDao.getProjectById(request.getProjectId()));
		task.setStartDate(DateUtils.toLocalDate(request.getStartDate()));
		task.setEndDate(DateUtils.toLocalDate(request.getEndDate()));
		task.setStatus(request.getStatus());
		task.setPriority(request.getPriority());
		task.setUser(projectManagementDao.getUserById(request.getUserId()));
		task.setTask(request.getTask());
		task.setTaskId(request.getTaskId());
		task.setParentTask(projectManagementDao.getParentTaskById(request.getParentId()));
		AddResponse response = new AddResponse(projectManagementDao.saveTask(task));
		return new ResponseEntity<AddResponse>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/addParentTask", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public ResponseEntity<AddResponse> addParentTask(@RequestBody AddParentTaskRequest request){
		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(request.getParentTaskId());
		parentTask.setParentTask(request.getParentTask());
		AddResponse response = new AddResponse(projectManagementDao.saveParentTask(parentTask));
		return new ResponseEntity<AddResponse>(response, HttpStatus.OK);
		
		
	}
	
	
	
}
