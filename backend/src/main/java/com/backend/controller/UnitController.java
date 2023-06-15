package com.backend.controller;

import com.backend.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/api/unit/add")
    public Map<String, String> addUnit(@RequestParam Map<String, String> map) {
        return unitService.addUnit(map);
    }

}
