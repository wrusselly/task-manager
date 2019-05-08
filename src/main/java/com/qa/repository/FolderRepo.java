package com.qa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.model.Folder;

public interface FolderRepo extends JpaRepository <Folder, Long>{
	List<Folder> findByUserId(Long userId);

}