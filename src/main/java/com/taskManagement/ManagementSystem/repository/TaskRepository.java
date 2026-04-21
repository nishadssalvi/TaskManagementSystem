package com.taskManagement.ManagementSystem.repository;

import com.taskManagement.ManagementSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
