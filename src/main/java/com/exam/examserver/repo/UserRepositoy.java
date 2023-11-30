package com.exam.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.examserver.model.User;

public interface UserRepositoy extends JpaRepository<User, Long> {
	public User findByUserName(String userName);
	
	public void deleteByUserName(@Param("key") String userName);
	
//	@Query("delete from User u where u.userName =:key")
//	public void deleteByUserName(@Param("key") String userName);

}
