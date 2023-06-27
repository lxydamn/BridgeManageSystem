package com.backend.service.impl;

import com.backend.mapper.BridgeCetPartMapper;
import com.backend.mapper.BridgeMapper;
import com.backend.pojo.BridgeCetPart;
import com.backend.pojo.BridgeInfo;
import com.backend.pojo.BridgeType;
import com.backend.service.BridgeCetPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeCetPartServiceImpl implements BridgeCetPartService {
    @Autowired
    BridgeMapper bridgeMapper;
    @Autowired
    BridgeCetPartMapper bridgeCetPartMapper;

    @Override
    public List<Map<String, Object>> getCetPartStatus(Map<String, Object> map) {
        List<Map<String, Object>> resp = new ArrayList<>();

        List<BridgeInfo> bridgeInfos = bridgeMapper.getBridgeByUnit(map);

        for (BridgeInfo bridgeInfo : bridgeInfos) {
            Integer cet_part = bridgeCetPartMapper.getCetPartCount(bridgeInfo.getBridge_no());
            Map<String, Object> item = new HashMap<>();

            item.put("cet_part", cet_part == 0 ? "unfinished" : "finish");
            item.put("bridge_no", bridgeInfo.getBridge_no());
            item.put("bridge_name", bridgeInfo.getBridge_name());
            item.put("type_no", bridgeInfo.getType_no());
            resp.add(item);
        }
        return resp;
    }

    @Override
    public List<Map<String,Object>> getAll(Map<String, Object> map) {
        return bridgeCetPartMapper.getAll(map);
    }

    @Override
    public Map<String, String> addCetPart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeCetPartMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> deleteCetPart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            bridgeCetPartMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> updateCetPart(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            System.out.println(map);
            bridgeCetPartMapper.update(map);

        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }
}
