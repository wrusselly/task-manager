package com.qa.controllers;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.User;
import com.qa.repository.UsersRepo;

@RestController
@RequestMapping("task-tracker/")
public class UsersController {
	
	@Autowired
	private UsersRepo usersRepo;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> list(){
		return usersRepo.findAll();
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public User create(@RequestBody User user){
		return usersRepo.saveAndFlush(user);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id){
        return usersRepo.findOne(id);
    }
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        User existingUser = usersRepo.findOne(id);
        BeanUtils.copyProperties(user, existingUser);
		return usersRepo.saveAndFlush(user);
    }
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id){
        User existingUser = usersRepo.findOne(id);
        usersRepo.delete(existingUser);
		return existingUser;
    }

}
