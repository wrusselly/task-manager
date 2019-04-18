package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Folder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long folderId;
	private String name;
	private Long userId;

	public Folder(Long folderId, String name, Long userId) {
		this.setFolderId(folderId);
		this.setName(name);
		this.setUserId(userId);
	}
	
	public Folder() {

	}
	
	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
