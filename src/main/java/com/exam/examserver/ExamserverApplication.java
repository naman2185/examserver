package com.exam.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code !!");
		
//		User user = new User();
//		user.setFirstName("Durgesh");
//		user.setLastName("Tiwari");
//		user.setUserName("durgesh8896");
//		user.setPassword("abc");
//		user.setEmail("abc@gmail.com");
//		user.setPhone("9998556644");
//		user.setProfile("default.png");
//		
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoles = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		
//		userRoles.add(userRole);
//		
//		User createdUser = this.userService.createUser(user, userRoles);
//		System.out.println("Created user's username:" + createdUser.getUserName());
		
		
	}

}
