package com.backend.controller;

import com.backend.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/api/basic/card/submit")
    public Map<String, String> submitData (@RequestParam Map<String, Object> map) {
        return basicCardService.submitData(map);
    }

    @GetMapping("/api/basic/tech/data")
    public Map<String, Object> getTechIndexData(@RequestParam Map<String, Object> map) {
        return basicCardService.getTechIndexData(map);
    }
    @GetMapping("/api/basic/card/data")
    public Map<String, Object> getBasicCardData(@RequestParam Map<String, Object> map) {
        return basicCardService.getBasicCardData(map);
    }

    @GetMapping("/api/basic/unitjob/data")
    public Map<String, Object> getUnitJobData(@RequestParam Map<String, Object> map) {
        return basicCardService.getUnitJob(map);
    }
    @GetMapping("/api/basic/file/data")
    public Map<String, Object> getFileData(@RequestParam Map<String, Object> map) {
        return basicCardService.getBridgeFileData(map);
    }

    @GetMapping("/api/basic/initcard/data")
    public Map<String, Object> getInitCardData(@RequestParam Map<String, Object> map) {
        return basicCardService.getInitCardData(map);
    }
}
