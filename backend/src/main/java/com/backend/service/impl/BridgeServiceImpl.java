package com.backend.service.impl;

import com.backend.mapper.BridgeMapper;
import com.backend.pojo.BridgeInfo;
import com.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Override
    public List<Map<String, Object>> getCardStatus(Map<String, Object> map) {
        List<Map<String, Object>> resp = new ArrayList<>();

        List<BridgeInfo> bridgeByUnit = bridgeMapper.getBridgeByUnit(map);

        for (BridgeInfo bridgeInfo : bridgeByUnit) {
            Integer basic = bridgeMapper.getBasicCardCountByBridgeNo(bridgeInfo.getBridge_no());
            Integer peri = bridgeMapper.getPeriCardCountByBridgeNo(bridgeInfo.getBridge_no());
            Integer init = bridgeMapper.getInitCardCountByBridgeNo(bridgeInfo.getBridge_no());
            Map<String, Object> item = new HashMap<>();

            item.put("basic", basic == 0 ? "unfinished" : "finish");
            item.put("peri", peri == 0 ? "unfinished" : "finish");
            item.put("init", init == 0 ? "unfinished" : "finish");
            item.put("bridge_no", bridgeInfo.getBridge_no());
            item.put("bridge_name", bridgeInfo.getBridge_name());
            resp.add(item);
        }

        return resp;
    }

    @Override
    public List<Map<String, Object>> getRouteByBridgeNo(Map<String, String> map) {
        return bridgeMapper.getRouteByBridgeNo(map);
    }
}
