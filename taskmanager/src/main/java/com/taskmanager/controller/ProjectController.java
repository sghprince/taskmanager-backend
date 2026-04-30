package com.taskmanager.controller;

import com.taskmanager.entity.Project;
import com.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/{userId}")
    public Project create(@RequestBody Project project, @PathVariable Long userId){
        return projectService.createProject(project, userId);
    }

    @GetMapping
    public List<Project> getAll(){
        return projectService.getAll();
    }
}
