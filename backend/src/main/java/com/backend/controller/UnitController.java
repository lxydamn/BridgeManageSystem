package com.backend.controller;

import com.backend.pojo.Unit;
import com.backend.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/api/unit/add")
    public Map<String, String> addUnit(@RequestParam Map<String, String> map) {
        return unitService.addUnit(map);
    }

    @GetMapping("/api/unit/get/all")
    public List<Unit> getAll() {
        return unitService.getAll();
    }
}
