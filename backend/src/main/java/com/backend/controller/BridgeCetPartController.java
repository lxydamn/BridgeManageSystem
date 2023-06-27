package com.backend.controller;

import com.backend.pojo.BridgeCetPart;
import com.backend.service.BridgeCetPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BridgeCetPartController {
    @Autowired
    BridgeCetPartService bridgeCetPartService;

    @GetMapping("/api/cetPart/status")
    public List<Map<String, Object>> cpnStatus(@RequestParam Map<String, Object> map) {
        return bridgeCetPartService.getCetPartStatus(map);
    }

    @GetMapping ("/api/cetPart/get")
    public List<Map<String,Object>> getCetPart(@RequestParam Map<String, Object> map) {
        return bridgeCetPartService.getAll(map);
    }

    @PostMapping("/api/cetPart/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return bridgeCetPartService.addCetPart(map);
    }

    @PostMapping("/api/cetPart/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return bridgeCetPartService.deleteCetPart(map);
    }

    @PostMapping("/api/cetPart/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return bridgeCetPartService.updateCetPart(map);
    }
}
