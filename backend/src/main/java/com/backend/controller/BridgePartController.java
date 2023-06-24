package com.backend.controller;

import com.backend.pojo.BridgePart;
import com.backend.service.BridgePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BridgePartController {
    @Autowired
    BridgePartService bridgePartService;

    @GetMapping("/api/bridgePart/get/all")
    public List<BridgePart> getAll() {
        return bridgePartService.getAll();
    }

    @PostMapping("/api/bridgePart/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return bridgePartService.addPart(map);
    }

    @PostMapping("/api/bridgePart/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return bridgePartService.deletePart(map);
    }

    @PostMapping("/api/bridgePart/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return bridgePartService.updatePart(map);
    }
}
