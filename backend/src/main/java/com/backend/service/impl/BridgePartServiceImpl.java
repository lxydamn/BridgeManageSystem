package com.backend.service.impl;

import com.backend.mapper.BridgePartMapper;
import com.backend.pojo.BridgePart;
import com.backend.service.BridgePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgePartServiceImpl implements BridgePartService {
    @Autowired
    BridgePartMapper bridgePartMapper;

    @Override
    public Map<String, String> addPart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgePartMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public List<BridgePart> getAll() {
        return bridgePartMapper.getAll();
    }

    @Override
    public Map<String, String> deletePart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgePartMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> updatePart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgePartMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }
}
