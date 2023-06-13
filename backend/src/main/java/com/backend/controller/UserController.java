package com.backend.controller;

import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/register")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        return userService.register(map);
    }

    @PostMapping("/api/user/login")
    public Map<String, String> login(@RequestParam Map<String, String> map) {
        return userService.login(map);
    }
}
