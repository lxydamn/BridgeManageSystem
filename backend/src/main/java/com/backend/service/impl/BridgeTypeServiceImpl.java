package com.backend.service.impl;

import com.backend.mapper.BridgeTypeMapper;
import com.backend.pojo.BridgeInfo;
import com.backend.pojo.BridgeType;
import com.backend.service.BridgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 19:57
 */

@Service
public class BridgeTypeServiceImpl implements BridgeTypeService {
    @Autowired
    private BridgeTypeMapper bridgeTypeMapper;

    @Override
    public Map<String, String> addType(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            bridgeTypeMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public Map<String, String> deleteType(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            bridgeTypeMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public Map<String, String> updateType(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            bridgeTypeMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public List<BridgeType> getAll() {

        return bridgeTypeMapper.getAll();
    }

    @Override
    public BridgeType getById(Map<String, Object> map) {

        return bridgeTypeMapper.selectById(map);
    }

    @Override
    public List<Map<String, Object>> getCount() {
        return bridgeTypeMapper.getTypeCount();
    }

    @Override
    public List<Map<String, Object>> getTypeCpnStatus() {
        List<Map<String, Object>> resp = new ArrayList<>();

        List<BridgeType> bridgeTypes = bridgeTypeMapper.getAll();

        for (BridgeType bridgeType : bridgeTypes) {
            Integer type_cpn = bridgeTypeMapper.getTypeCpnCount(bridgeType.getType_no());
            System.out.println(type_cpn);
            Map<String, Object> item = new HashMap<>();

            item.put("type_cpn", type_cpn == 0 ? "unfinished" : "finish");
            item.put("type_no", bridgeType.getType_no());
            item.put("type_name", bridgeType.getType_name());
            resp.add(item);
        }
        return resp;
    }

}
