package com.backend.service.impl;

import com.backend.mapper.BridgeMapper;
import com.backend.mapper.UnitJobMapper;
import com.backend.mapper.UnitMapper;
import com.backend.pojo.BridgeInfo;
import com.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeServiceImpl implements BridgeService {

    @Autowired
    private BridgeMapper bridgeMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private UnitJobMapper unitJobMapper;

    @Override
    @Transactional
    public Map<String, String> addBridge(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            bridgeMapper.insert(map);
            unitJobMapper.insertOne(map);
            bridgeMapper.insertLL(map);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public BridgeInfo getBridge(Map<String, String> map) {
        return bridgeMapper.selectById(map);
    }

    @Override
    public List<Map<String, Object>> getBridgeLL(Map<String, String> map) {

        List<String> bridgeNos = unitMapper.getBridgeNoByUnit(map.get("unit_no"));
        List<Map<String, Object>> resp = new ArrayList<>();
        for (String bridgeNo : bridgeNos) {
            resp.add(bridgeMapper.getBridgeLL(bridgeNo));
        }
        return resp;
    }

    @Override
    public List<Map<String, Object>> getAllByUnitNo(Map<String, Object> map) {

        List<Map<String , Object>> resp = new ArrayList<>();
        List<BridgeInfo> bridgeByUnit = bridgeMapper.getBridgeByUnit(map);

        for (BridgeInfo bridgeInfo : bridgeByUnit) {
            resp.add(bridgeMapper.getBridgeInfoAndAbout(bridgeInfo.getBridge_no()));
        }

       return resp;
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
    @Transactional
    public Map<String, String> updateBridge(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            bridgeMapper.update(map);
            bridgeMapper.updateBridgeLL(map);
        } catch (Exception e) {
            throw new RuntimeException();
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
}
