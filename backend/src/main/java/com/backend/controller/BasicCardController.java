package com.backend.controller;

import com.backend.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:15
 */

@RestController
public class BasicCardController {

    @Autowired
    private BasicCardService basicCardService;

    @GetMapping("/api/assess/record/get")
    public List<Map<String, Object>> getAssessRecord(@RequestParam Map<String, Object> map) {
        return basicCardService.getAssessRecord(map);
    }

    @GetMapping("/api/maintain/record/get")
    public List<Map<String, Object>> getMaintainRecord(@RequestParam Map<String, Object> map) {
        return basicCardService.getMaintainRecord(map);
    }
}
