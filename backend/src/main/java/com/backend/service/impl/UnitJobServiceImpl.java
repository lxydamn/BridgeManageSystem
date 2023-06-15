package com.backend.service.impl;

import com.backend.mapper.UnitJobMapper;
import com.backend.service.UnitJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UnitJobServiceImpl implements UnitJobService {

    @Autowired
    private UnitJobMapper unitJobMapper;

    @Override
    public Map<String, String> addUnitJob(Map<String, String> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            unitJobMapper.insertOne(map);
        } catch (Exception e) {
            resp.put("error_info", "插入错误");
            return resp;
        }

        return resp;
    }
}
