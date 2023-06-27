package com.backend.service.impl;

import com.backend.mapper.BridgeTypeCpnMapper;
import com.backend.pojo.BridgeTypeCpn;
import com.backend.service.BridgeTypeCpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeTypeCpnServiceImpl implements BridgeTypeCpnService {
    @Autowired
    BridgeTypeCpnMapper bridgeTypeCpnMapper;

    @Override
    public Map<String, String> addTypeCpn(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeTypeCpnMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public List<Map<String, Object>> getAll(Map<String, Object> map) {
        return bridgeTypeCpnMapper.getAll(map);
    }

    @Override
    public Map<String, String> deleteTypeCpn(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeTypeCpnMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> updateTypeCpn(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeTypeCpnMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }
}
