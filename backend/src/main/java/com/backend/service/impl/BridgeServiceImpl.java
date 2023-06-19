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
}
