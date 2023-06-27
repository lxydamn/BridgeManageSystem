package com.backend.controller;

import com.alibaba.fastjson2.JSONArray;
import com.backend.service.PeriCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PeriCardController {
    @Autowired
    PeriCardService periCardService;

    @GetMapping("/api/periCard/get/initCardInfo")
    public Map<String, Object> getInitCardInfo(@RequestParam Map<String, Object> map) {
        return periCardService.getInitCardInfo(map);
    }

    @GetMapping("/api/periCard/get/buildTime")
    public Map<String, Object> getBuildTime(@RequestParam Map<String, Object> map) {
        return periCardService.getBuildTime(map);
    }

    @GetMapping("/api/periCard/get/structRecord")
    public JSONArray getStructRecord(@RequestParam Map<String, Object> map) {
        return periCardService.getStructRecord(map);
    }
}
