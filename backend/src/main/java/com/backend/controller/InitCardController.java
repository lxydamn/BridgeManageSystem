package com.backend.controller;

import com.backend.service.InitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InitCardController {
    @Autowired
    InitCardService initCardService;

    @PostMapping("/api/bridge/initCard/add")
    public Map<String, String> addBridge(@RequestParam Map<String, String> map) {
        return initCardService.addInitCard(map);
    }
}
