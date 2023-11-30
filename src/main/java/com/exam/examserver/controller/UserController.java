package com.exam.examserver.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	// create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		Role role = new Role(45L, "NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);
		
		return this.userService.createUser(user, userRoles);
		
	}
	
	@GetMapping("/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return this.userService.getUserByUserName(userName);
	}
	
	@Transactional
	@DeleteMapping("/{userName}")
	public void deleteUserByUserName(@PathVariable String userName) {
		this.userService.deleteUserByUserName(userName);
	}
}
