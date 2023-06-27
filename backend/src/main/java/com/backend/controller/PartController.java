package com.backend.controller;


import com.alibaba.fastjson2.JSONArray;
import com.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 15:59
 */

@RestController

public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping("/api/part/get/info")
    public JSONArray getStructInfo(@RequestParam Map<String, Object> map) {
        return partService.getStructInfo(map);
    }
}
