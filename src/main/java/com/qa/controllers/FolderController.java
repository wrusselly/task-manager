package com.qa.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.Folder;
import com.qa.repository.FolderRepo;

@RestController
@RequestMapping("api/task-tracker/")
public class FolderController {
	
	@Autowired
	private FolderRepo folderRepo;
	
	@RequestMapping(value = "folder", method = RequestMethod.GET)
	public List<Folder> list(){
		return folderRepo.findAll();
	}
	
	@RequestMapping(value = "folder", method = RequestMethod.POST)
	public Folder create(@RequestBody Folder folder){
		return folderRepo.saveAndFlush(folder);
	}
	
	@RequestMapping(value = "folder/{id}", method = RequestMethod.GET)
    public Folder get(@PathVariable Long id){
        return folderRepo.findOne(id);
    }
	
	@RequestMapping(value = "folder/{id}", method = RequestMethod.PUT)
    public Folder update(@PathVariable Long id, @RequestBody Folder folder){
        Folder existingFolder = folderRepo.findOne(id);
        BeanUtils.copyProperties(folder, existingFolder);
		return folderRepo.saveAndFlush(folder);
    }
	
	@RequestMapping(value = "folder/{id}", method = RequestMethod.DELETE)
    public Folder delete(@PathVariable Long id){
        Folder existingFolder = folderRepo.findOne(id);
        folderRepo.delete(existingFolder);
		return existingFolder;
    }
	
	@RequestMapping(value = "folder//{userId}", method = RequestMethod.GET)
	public List<Folder> findByUserId(@PathVariable Long userId){
		return folderRepo.findByUserId(userId);
	}

}
