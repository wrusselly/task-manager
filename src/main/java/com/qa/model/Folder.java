package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Folder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long listId;
	private String name;

	public Folder(Long listId, String name) {
		this.setListId(listId);
		this.setName(name);
	}
	
	public Folder() {

	}
	
	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
