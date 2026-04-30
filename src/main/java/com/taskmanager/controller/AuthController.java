package com.taskmanager.controller;

import com.taskmanager.entity.User;
import com.taskmanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return authService.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return authService.login(user.getEmail(), user.getPassword());
    }
}
