package com.cts.projectManagement.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.projectManagement.entity.User;
import com.cts.projectManagement.repository.AddUserRepository;

@Component
public class ProjectManagementDao {
	public final static Logger logger = LoggerFactory.getLogger(ProjectManagementDao.class);
	
	@Autowired
	AddUserRepository addUserRepository;
	
	public boolean saveUser(User user) {
		try {
		addUserRepository.save(user);
		}catch(Exception e) {
			logger.error("An error occured while saving the user",e);
			return false;
		}
		return true;
		
	}

}
