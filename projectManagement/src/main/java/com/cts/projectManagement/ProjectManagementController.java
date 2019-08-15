package com.cts.projectManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.projectManagement.dao.ProjectManagementDao;
import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.model.AddUserRequest;
import com.cts.projectManagement.model.AddUserResponse;

@Controller
public class ProjectManagementController {
	@Autowired
	ProjectManagementDao projectManagementDao;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")

	public ResponseEntity<AddUserResponse> addUser(@RequestBody AddUserRequest userRequest) {
		User user = new User();
		
		user.setEmployeeId(userRequest.getEmployeeId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		AddUserResponse response= new AddUserResponse(projectManagementDao.saveUser(user));
		return new ResponseEntity<AddUserResponse>(response, HttpStatus.OK);
		

	}

}
