package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.model.Task;

public interface TaskRepo extends JpaRepository <Task, Long>{

}
