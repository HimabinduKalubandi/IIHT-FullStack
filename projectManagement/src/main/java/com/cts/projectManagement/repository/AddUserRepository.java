package com.cts.projectManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectManagement.entity.User;

@Repository
public interface AddUserRepository extends CrudRepository<User,Long> {
	

}
