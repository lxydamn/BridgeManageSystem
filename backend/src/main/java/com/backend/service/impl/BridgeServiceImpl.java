package com.backend.service.impl;

import com.backend.mapper.BridgeMapper;
import com.backend.pojo.BridgeInfo;
import com.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeServiceImpl implements BridgeService {

    @Autowired
    private BridgeMapper bridgeMapper;

    @Override
    public Map<String, String> addBridge(Map<String, String> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            bridgeMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "新建失败");
            return resp;
        }

        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public BridgeInfo getBridge(Map<String, String> map) {
        return bridgeMapper.selectById(map);
    }

    @Override
    public List<Map<String, Object>> getAll() {
        return bridgeMapper.getAll();
    }

    @Override
    public Map<String, Object> getCountByUnit(Map<String, Object> map) {

        Map<String, Object> resp = new HashMap<>();

        resp.put("bridgeCount", bridgeMapper.getCountByUnit(map));
        resp.put("basicCardCount", bridgeMapper.getBasicCardCount(map));
        resp.put("initRecordCount", bridgeMapper.getInitRecordCount(map));
        resp.put("periRecordCount", bridgeMapper.getPeriRecordCount(map));

        return resp;
    }

    @Override
    public Map<String, String> updateBridge(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            bridgeMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }

        resp.put("error_info", "success");
        return resp;
    }
}
