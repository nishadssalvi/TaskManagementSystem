package com.taskManagement.ManagementSystem.service;

import com.taskManagement.ManagementSystem.dto.TaskDTO;
import com.taskManagement.ManagementSystem.entity.Task;
import com.taskManagement.ManagementSystem.exception.ResourceNotFoundException;
import com.taskManagement.ManagementSystem.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task createTask(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return repo.save(task);
    }

    public Task updateTask(Long id, TaskDTO dto) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());

        return repo.save(task);
    }

    public void deleteTask(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Task not found");
        }
        repo.deleteById(id);
    }
}



