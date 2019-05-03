package com.qa.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.Task;
import com.qa.repository.TaskRepo;

@RestController
@RequestMapping("task-tracker/")
public class TaskController {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@RequestMapping(value = "task", method = RequestMethod.GET)
	public List<Task> list(){
		return taskRepo.findAll();
	}
	
	@RequestMapping(value = "task", method = RequestMethod.POST)
	public Task create(@RequestBody Task task){
		return taskRepo.saveAndFlush(task);
	}
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.GET)
    public Task get(@PathVariable Long id){
        return taskRepo.findOne(id);
    }
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable Long id, @RequestBody Task task){
        Task existingTask = taskRepo.findOne(id);
        BeanUtils.copyProperties(task, existingTask);
		return taskRepo.saveAndFlush(task);
    }
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.DELETE)
    public Task delete(@PathVariable Long id){
        Task existingTask = taskRepo.findOne(id);
        taskRepo.delete(existingTask);
		return existingTask;
    }
	
	@RequestMapping(value = "task//{complete}", method = RequestMethod.GET)
	public List<Task> findByComplete(@PathVariable boolean complete){
		return taskRepo.findByComplete(complete);
	}
	
	@RequestMapping(value = "task/{userId}/{folderId}/{complete}", method = RequestMethod.GET)
	public List<Task> findByUserIdAndFolderIdAndComplete(@PathVariable Long userId, @PathVariable Long folderId, @PathVariable boolean complete){
		return taskRepo.findByUserIdAndFolderIdAndComplete(userId, folderId, complete);
	}
	
	@RequestMapping(value = "task/{userId}/{complete}", method = RequestMethod.GET)
	List<Task> findByUserIdAndComplete(@PathVariable Long userId, @PathVariable boolean complete){
		return taskRepo.findByUserIdAndComplete(userId, complete);
	}

}
