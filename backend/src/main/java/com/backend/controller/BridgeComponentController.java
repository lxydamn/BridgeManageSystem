package com.backend.controller;

import com.backend.pojo.BridgeCpn;
import com.backend.service.BridgeComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BridgeComponentController {
    @Autowired
    BridgeComponentService bridgeComponentService;

    @GetMapping("/api/bridgeComponent/get/all")
    public List<BridgeCpn> getAll() {
        return bridgeComponentService.getAll();
    }

    @PostMapping("/api/bridgeComponent/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return bridgeComponentService.addComponent(map);
    }

    @PostMapping("/api/bridgeComponent/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return bridgeComponentService.deleteComponent(map);
    }

    @PostMapping("/api/bridgeComponent/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return bridgeComponentService.updateComponent(map);
    }
}
