package com.taskmanager.service;

import com.taskmanager.entity.Project;
import com.taskmanager.entity.Task;
import com.taskmanager.entity.User;
import com.taskmanager.repository.ProjectRepository;
import com.taskmanager.repository.TaskRepository;
import com.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Task createTask(Task task, Long userId) {

        User admin = userRepository.findById(userId).orElseThrow();

        if(!admin.getRole().equals("ADMIN")){
            throw new RuntimeException("Only admin can assign tasks");
        }

        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task updateStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public Map<String, Long> dashboard() {
        Map<String, Long> data = new HashMap<>();
        data.put("total", taskRepository.count());
        data.put("done", taskRepository.countByStatus("DONE"));
        return data;
    }
}
