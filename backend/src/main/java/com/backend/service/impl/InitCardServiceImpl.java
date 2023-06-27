package com.backend.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.backend.mapper.InitCardMapper;
import com.backend.mapper.UnitJobMapper;
import com.backend.pojo.UnitJob;
import com.backend.service.InitCardService;
import com.backend.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class InitCardServiceImpl implements InitCardService {

    @Autowired
    InitCardMapper initCardMapper;

    @Autowired
    UnitJobMapper unitJobMapper;

    @Override
    @Transactional
    public Map<String, String> addInitCard(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        String bridge_no = (String) map.get("bridge_no");
        map.remove("bridge_no");
        String initRecordNo = UIDUtil.getUUID(12);

        try {
            for (Map.Entry<String, Object> item : map.entrySet()) {
                System.out.println(item);
                Map<String, Object> data = JSONObject.parse(String.valueOf(item.getValue()));
                if (item.getKey().equals("arr")) {
                    data.put("init_record_no", initRecordNo);
                    data.put("bridge_no", bridge_no);
                    data.replace("init_time", data.get("init_time").toString().substring(0, 10));
                    data.replace("del_time", data.get("del_time").toString().substring(0, 10));
                    initCardMapper.insertInitCard(data);
                } else {
                    Integer construction_unit = Integer.parseInt(String.valueOf(data.get("construction_unit")));
                    Integer design_unit = Integer.parseInt(String.valueOf(data.get("design_unit")));
                    UnitJob unitJob = new UnitJob(construction_unit, bridge_no, "施工");
                    unitJobMapper.insertByUnitJob(unitJob);
                    UnitJob unitJob1 = new UnitJob(design_unit, bridge_no, "设计");
                    unitJobMapper.insertByUnitJob(unitJob1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, Object> getUnitJob(Map<String, Object> map) {
        Map<String, Object> resp = new HashMap<>();
        map.put("unit_job", "设计");
        resp.put("design_unit", unitJobMapper.getUnitJobData(map));
        map.replace("unit_job", "施工");
        resp.put("construction_unit",unitJobMapper.getUnitJobData(map));
        return resp;
    }

    @Override
    public Map<String, Object> getInitCard(Map<String, Object> map) {
        return initCardMapper.getInitCard(map);
    }
}
