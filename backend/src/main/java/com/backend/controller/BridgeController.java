package com.backend.controller;

import com.backend.pojo.BridgeInfo;
import com.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/19 9:01
 */

@RestController
public class BridgeController {

    @Autowired
    private BridgeService bridgeService;

    @GetMapping("/api/bridge/get/all")
    public List<Map<String, Object>> getAll() {
        return bridgeService.getAll();
    }

    @GetMapping("/api/bridge/card/status")
    public List<Map<String, Object>> cardStatus(@RequestParam Map<String, Object> map) {
        return bridgeService.getCardStatus(map);
    }

    @GetMapping("/api/bridge/unit/count")
    public Map<String, Object> getCountByUnit(@RequestParam Map<String, Object> map) {
        return bridgeService.getCountByUnit(map);
    }
    @PostMapping("/api/bridge/update")
    public Map<String, String> updateBridge(@RequestParam Map<String, Object> map) {
        return bridgeService.updateBridge(map);
    }

    @PostMapping("/api/bridge/add")
    public Map<String, String> addBridge(@RequestParam Map<String, String> map) {
        return bridgeService.addBridge(map);
    }

    @GetMapping("/api/bridge/get/id")
    public BridgeInfo getBridge(@RequestParam Map<String, String> map) {
        return bridgeService.getBridge(map);
    }
}
