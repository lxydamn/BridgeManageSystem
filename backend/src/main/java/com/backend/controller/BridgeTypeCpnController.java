package com.backend.controller;

import com.backend.pojo.BridgePart;
import com.backend.pojo.BridgeTypeCpn;
import com.backend.service.BridgeTypeCpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BridgeTypeCpnController {
    @Autowired
    BridgeTypeCpnService bridgeTypeCpnService;

    @GetMapping("/api/bridgeTypeCpn/get/all")
    public List<BridgeTypeCpn> getAll(@RequestParam Map<String, Object> map) {
        return bridgeTypeCpnService.getAll(map);
    }

    @PostMapping("/api/bridgeTypeCpn/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return bridgeTypeCpnService.addTypeCpn(map);
    }

    @PostMapping("/api/bridgeTypeCpn/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return bridgeTypeCpnService.deleteTypeCpn(map);
    }

    @PostMapping("/api/bridgeTypeCpn/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return bridgeTypeCpnService.updateTypeCpn(map);
    }
}
