package com.cts.projectManagement.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.projectManagement.ProjectManagementController;
import com.cts.projectManagement.dao.ProjectManagementDao;
import com.cts.projectManagement.model.AddResponse;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProjectManagemnetControllerTest {
	@Mock
	ProjectManagementController controller;
	
	@InjectMocks
	ProjectManagementDao dao;
	
	AddResponse response;
	
	/*
	 * @Test public void testAddUser() { AddUserRequest userRequest= new
	 * AddUserRequest(); userRequest.setEmployeeId(101L);
	 * userRequest.setFirstName("xxxx"); userRequest.setLastName("yyyy"); User user=
	 * new User();
	 * 
	 * controller.addUser(userRequest);
	 * when(dao.saveUser(user)).thenReturn(saveUser());
	 * assertEquals(response.isAddIndicator(),true);
	 * 
	 * }
	 * 
	 * private Boolean saveUser() { response= new AddUserResponse(true); return
	 * true; }
	 */

}
