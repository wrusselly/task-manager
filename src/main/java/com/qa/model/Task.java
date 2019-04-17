package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	private Long userId;
	private Long listId;
	private String text;
	private String dateSetStr;
	private String dateDueStr;
	private String dateCompletedStr;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDateSetStr() {
		return dateSetStr;
	}

	public void setDateSetStr(String dateSetStr) {
		this.dateSetStr = dateSetStr;
	}

	public String getDateDueStr() {
		return dateDueStr;
	}

	public void setDateDueStr(String dateDueStr) {
		this.dateDueStr = dateDueStr;
	}

	public String getDateCompletedStr() {
		return dateCompletedStr;
	}

	public void setDateCompletedStr(String dateCompletedStr) {
		this.dateCompletedStr = dateCompletedStr;
	}

	public Task(Long taskId, Long userId, Long listId, String text, String dateSetStr, String dateDueStr, String dateCompletedStr) {
		this.setTaskId(taskId);
		this.setUserId(userId);
		this.setListId(listId);
		this.setText(text);
		this.setDateSetStr(dateSetStr);
		this.setDateDueStr(dateDueStr);
		this.setDateCompletedStr(dateCompletedStr);
	}

	public Task() {

	}

}
