package com.taskmanager.controller;

import com.taskmanager.entity.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{userId}")
    public Task create(@RequestBody Task task, @PathVariable Long userId){
        return taskService.createTask(task, userId);
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @PatchMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestParam String status){
        return taskService.updateStatus(id, status);
    }

    @GetMapping("/dashboard")
    public Map<String, Long> dashboard(){
        return taskService.dashboard();
    }
}
