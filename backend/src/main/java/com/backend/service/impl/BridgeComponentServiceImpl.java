package com.backend.service.impl;

import com.backend.mapper.BridgeComponentMapper;
import com.backend.pojo.BridgeCpn;
import com.backend.service.BridgeComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeComponentServiceImpl implements BridgeComponentService {

    @Autowired
    BridgeComponentMapper bridgeComponentMapper;

    @Override
    public Map<String, String> addComponent(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeComponentMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public List<BridgeCpn> getAll() {
        return bridgeComponentMapper.getAll();
    }

    @Override
    public Map<String, String> deleteComponent(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeComponentMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> updateComponent(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeComponentMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }
}
