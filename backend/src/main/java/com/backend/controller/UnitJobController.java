package com.backend.controller;

import com.backend.service.UnitJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UnitJobController {

    @Autowired
    private UnitJobService unitJobService;

    @PostMapping("/api/unitJob/add")
    public Map<String, String> addUnitJob(@RequestParam Map<String, String> map) {
        return unitJobService.addUnitJob(map);
    }
}