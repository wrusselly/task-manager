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
	private String text;
	private String dateSetStr;
	private String dateDueStr;
	private String dateCompletedStr;
	private Long userId;
	private Long folderId;
	private boolean complete = false;
	


	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public Task(Long taskId, Long userId, Long folderId, String text, String dateSetStr, String dateDueStr, String dateCompletedStr, boolean complete) {
		this.setTaskId(taskId);
		this.setText(text);
		this.setDateSetStr(dateSetStr);
		this.setDateDueStr(dateDueStr);
		this.setDateCompletedStr(dateCompletedStr);
		this.setUserId(userId);
		this.setFolderId(folderId);
		this.setComplete(complete);
	}
	
	public Task() {

	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
