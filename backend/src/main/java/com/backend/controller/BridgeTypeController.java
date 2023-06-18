package com.backend.controller;

import com.backend.pojo.BridgeType;
import com.backend.pojo.Route;
import com.backend.service.BridgeTypeService;
import com.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 20:02
 */
@RestController
public class BridgeTypeController {
    @Autowired
    private BridgeTypeService bridgeTypeService;

    @GetMapping("/api/bridgeType/get/all")
    public List<BridgeType> getAll() {
        return bridgeTypeService.getAll();
    }

    @PostMapping("/api/bridgeType/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return bridgeTypeService.updateRoute(map);
    }

    @PostMapping("/api/bridgeType/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return bridgeTypeService.addRoute(map);
    }

    @PostMapping("/api/bridgeType/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return bridgeTypeService.deleteRoute(map);
    }
    @GetMapping("/api/bridgeType/get/id")
    public BridgeType getById(@RequestParam Map<String, Object> map) {
        return bridgeTypeService.getById(map);
    }
}
