package com.backend.controller;

import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/register")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        return userService.register(map);
    }

    @GetMapping("/api/user/get/all")
    public List<Map<String, Object>> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/user/delete")
    public Map<String, String> deleteOne(@RequestParam Map<String, String> map) {
        return userService.deleteOne(map);
    }

    @GetMapping("/api/uu/count")
    public Map<String, Object> getUUCount() {
        return userService.getUUCount();
    }

    @PostMapping("/api/user/update")
    public Map<String, String> update(@RequestParam Map<String, String> map) {
        return userService.update(map);
    }
    @PostMapping("/api/user/login")
    public Map<String, String> login(@RequestParam Map<String, String> map) {
        return userService.login(map);
    }
}
