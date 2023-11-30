package com.exam.examserver.service.impl;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repo.RoleRepository;
import com.exam.examserver.repo.UserRepositoy;
import com.exam.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositoy userRepositoy;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception { 
		
		User local = this.userRepositoy.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("User is already there !!");
			throw new Exception("User is already there !!");
		}
		else {
			for(UserRole ur : userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepositoy.save(user);
		}
		
		return user;
	}

	@Override
	public User getUserByUserName(String userName) {
		return this.userRepositoy.findByUserName(userName);
	}

	@Override
	public void deleteUserByUserName(String userName) {
		this.userRepositoy.deleteByUserName(userName);
		
	}

}
