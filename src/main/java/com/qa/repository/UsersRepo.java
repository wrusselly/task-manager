package com.qa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.model.User;

public interface UsersRepo extends JpaRepository <User, Long>{
	
	List<User> findByUsername(String username);
	List<User> findByUsernameAndPassword(String username, String password);
	

}