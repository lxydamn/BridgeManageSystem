package com.backend.controller;

import com.backend.pojo.AssessRecord;
import com.backend.pojo.MaintainRecord;
import com.backend.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/25 20:11
 */
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/api/record/assess/add")
    public Map<String, String> insertAssessRecord(@RequestParam Map<String, Object> map) {
        return recordService.insertAssessRecord(map);
    }

    @PostMapping("/api/record/maintain/add")
    public Map<String, String> insertMaintainRecord(@RequestParam Map<String, Object> map) {
        return recordService.insertMaintainRecord(map);
    }

    @PostMapping("/api/record/assess/delete")
    public Map<String, String> deleteAssessRecord(@RequestParam Map<String, Object> map) {
        return recordService.deleteAssessRecord(map);
    }

    @PostMapping("/api/record/maintain/delete")
    public Map<String, String> deleteMaintainRecord(@RequestParam Map<String, Object> map) {
        return recordService.deleteMaintainRecord(map);
    }

    @GetMapping("/api/record/assess/withbc")
    public List<Map<String, Object>> getAssessRecordWithBC() {
        return recordService.getAssessRecordWithBS();
    }

    @GetMapping("/api/record/maintain/withbc")
    public List<Map<String, Object>> getMaintainRecordWithBC() {
        return recordService.getMaintainRecordWithBS();
    }

    @GetMapping("/api/record/bridgeToCard/get")
    public List<Map<String, Object>> getBridgeToCard() {
        return recordService.getBridgeToCard();
    }

    @GetMapping("/api/record/data/get")
    public Map<String, Object> getRecordDataCount() {
        return recordService.getRecordDataCount();
    }
}
