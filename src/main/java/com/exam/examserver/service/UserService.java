package com.exam.examserver.service;

import java.util.Set;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;

public interface UserService {
	//create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get User by userName
	
	public User getUserByUserName(String userName);
	public void deleteUserByUserName(String userName);

}
