package com.backend.service.impl;

import com.backend.mapper.RecordMapper;
import com.backend.service.RecordService;
import com.backend.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/25 20:08
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;


    @Override
    public Map<String, String> insertAssessRecord(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();
        String no = UIDUtil.getUUID(10);
        try {
            map.put("ase_rcd_no", no);
            recordMapper.insertAssessRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> insertMaintainRecord(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        String no = UIDUtil.getUUID(10);
        try {
            map.put("tre_rcd_no", no);
            recordMapper.insertMaintainRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> deleteAssessRecord(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            recordMapper.deleteAssessRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> deleteMaintainRecord(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            recordMapper.deleteMaintainRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public List<Map<String, Object>> getAssessRecordWithBS() {
        return recordMapper.getAssessRecordWithBC();
    }

    @Override
    public List<Map<String, Object>> getMaintainRecordWithBS() {
        return recordMapper.getMaintainRecordWithBC();
    }

    @Override
    public List<Map<String, Object>> getBridgeToCard() {
        return recordMapper.getBridgeToCard();
    }
}
