package com.backend.controller;

import com.backend.service.InitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InitCardController {
    @Autowired
    InitCardService initCardService;

    @PostMapping("/api/initCard/submit")
    public Map<String, String> submitData(@RequestParam Map<String, Object> map) {
        return initCardService.addInitCard(map);
    }

    @GetMapping("/api/initCard/get/cardInfo")
    public Map<String, Object> getInitCard(@RequestParam Map<String, Object> map) {
        return initCardService.getInitCard(map);
    }

    @GetMapping("/api/initCard/get/unitJob")
    public Map<String, Object> getUnitJobData(@RequestParam Map<String, Object> map) {
        return initCardService.getUnitJob(map);
    }

}
