package com.backend.controller;

import com.backend.pojo.BridgeInfo;
import com.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/19 9:01
 */

@RestController
public class BridgeController {

    @Autowired
    private BridgeService bridgeService;

    @PostMapping("/api/bridge/add")
    public Map<String, String> addBridge(@RequestParam Map<String, String> map) {
        return bridgeService.addBridge(map);
    }

    @GetMapping("/api/bridge/get")
    public BridgeInfo getBridge(@RequestParam Map<String, String> map) {
        return bridgeService.getBridge(map);
    }
}
