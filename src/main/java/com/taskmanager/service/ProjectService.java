package com.taskmanager.service;

import com.taskmanager.entity.Project;
import com.taskmanager.entity.User;
import com.taskmanager.repository.ProjectRepository;
import com.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Project createProject(Project project, Long userId) {

        User user = userRepository.findById(userId).orElseThrow();

        if(!user.getRole().equals("ADMIN")){
            throw new RuntimeException("Only admin can create project");
        }

        project.setCreatedBy(user);
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}