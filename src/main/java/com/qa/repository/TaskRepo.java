package com.qa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.model.Task;


public interface TaskRepo extends JpaRepository <Task, Long>{
	List<Task> findByComplete(boolean complete);
	List<Task> findByUserIdAndFolderIdAndComplete(Long userId, Long folderId, boolean complete);
	List<Task> findByUserIdAndComplete(Long userId, boolean complete);

}
