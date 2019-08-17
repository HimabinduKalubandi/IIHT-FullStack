package com.cts.projectManagement.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.cts.projectManagement.entity.Project;
import com.cts.projectManagement.entity.Task;
import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.model.ProjectDetail;
import com.cts.projectManagement.model.ProjectDetailResponse;
import com.cts.projectManagement.model.ProjectsList;
import com.cts.projectManagement.model.TaskDetailsResponse;
import com.cts.projectManagement.model.TaskDetail;
import com.cts.projectManagement.model.UserDetail;
import com.cts.projectManagement.model.UserDetailsResponse;

@Component
public class ProjectManagementMapper {

	public UserDetailsResponse mapUserResponse(List<User> users) {
		List<UserDetail> usersList = new ArrayList<UserDetail>();
		UserDetailsResponse response = new UserDetailsResponse();
		for (User user : users) {
			UserDetail userDetail = new UserDetail();
			userDetail.setEmployeeId(user.getEmployeeId());
			userDetail.setFirstName(user.getFirstName());
			userDetail.setUserId(user.getUserId());
			userDetail.setLastName(user.getLastName());
			usersList.add(userDetail);
		}
		response.setUsersList(usersList);
		return response;

	}

	public TaskDetailsResponse mapTaskResponse(List<Project> projects) {
		ProjectDetail projectDetail = null;
		List<ProjectDetail> projectDetails = new ArrayList<ProjectDetail>();
		TaskDetailsResponse response = new TaskDetailsResponse();
		if (projects != null) {

			List<TaskDetail> list = null;
			for (Project project : projects) {
				projectDetail = new ProjectDetail();
				list = new ArrayList<TaskDetail>();
				projectDetail.setProject(project.getProject());
				projectDetail.setProjectId(project.getProjectId());
				projectDetail.setPriority(project.getPriority());
				projectDetail.setStartDate(project.getDate());
				projectDetail.setEndDate(project.getEndDate());
				if (!CollectionUtils.isEmpty(project.getTasks())) {

					for (Task task : project.getTasks()) {
						TaskDetail taskDetail = new TaskDetail();
						if (task.getParentTask() != null) {
							taskDetail.setParentId(task.getParentTask().getParentId());
							taskDetail.setParentTask(task.getParentTask().getParentTask());
						}
						taskDetail.setTask(task.getTask());
						taskDetail.setStatus(task.getStatus());
						taskDetail.setStartDate(task.getStartDate());
						taskDetail.setEndDate(task.getEndDate());
						taskDetail.setPriority(task.getPriority());
						taskDetail.setTaskId(task.getTaskId());
						taskDetail.setProjectId(task.getProject().getProjectId());
						taskDetail.setUserId(task.getUser().getUserId());
						list.add(taskDetail);

					}

				}
				projectDetail.setTaskDetails(list);
				projectDetails.add(projectDetail);
			}
			response.setProjectDetails(projectDetails);
		}
		return response;
	}

	public ProjectDetail mapProjectResponse(Project project) {
		ProjectDetail projectDetail = null;

		if (project != null) {
			projectDetail = new ProjectDetail();
			List<TaskDetail> list = null;

			projectDetail.setProject(project.getProject());
			projectDetail.setProjectId(project.getProjectId());
			projectDetail.setPriority(project.getPriority());
			projectDetail.setStartDate(project.getDate());
			projectDetail.setEndDate(project.getEndDate());
			if (!CollectionUtils.isEmpty(project.getTasks())) {
				list = new ArrayList<TaskDetail>();
				for (Task task : project.getTasks()) {
					TaskDetail taskDetail = new TaskDetail();
					taskDetail.setParentId(null);
					taskDetail.setTask(task.getTask());
					taskDetail.setStatus(task.getStatus());
					taskDetail.setStartDate(task.getStartDate());
					taskDetail.setEndDate(task.getEndDate());
					taskDetail.setPriority(task.getPriority());
					taskDetail.setTaskId(task.getTaskId());
					taskDetail.setProjectId(task.getProject().getProjectId());
					taskDetail.setUserId(task.getUser().getUserId());
					list.add(taskDetail);

				}

			}
			projectDetail.setTaskDetails(list);

		}

		return projectDetail;
	}

	public ProjectsList mapProjectResponse(List<Project> projects) {
		ProjectDetailResponse response = null;
		ProjectsList projectsList= new ProjectsList();
		List<ProjectDetailResponse> list = new ArrayList<ProjectDetailResponse>();
		if (projects != null) {
			for (Project project : projects) {
				response = new ProjectDetailResponse();
				response.setProjectId(project.getProjectId());
				response.setProject(project.getProject());
				response.setStartDate(project.getDate());
				response.setEndDate(project.getEndDate());
				response.setPriority(project.getPriority());
				response.setNoOfTasks(project.getTasks() != null ? project.getTasks().size() : 0);
				if (project.getTasks() != null) {
					response.setNoofTasksCompleted(
							(int) project.getTasks().stream().filter(c -> "Complete".equals(c.getStatus())).count());
				}
				list.add(response);

			}
			
			projectsList.setProjectDetailResponse(list);

		}
		return projectsList;

	}

}
