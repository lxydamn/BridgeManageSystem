package com.backend.service.impl;

import com.backend.mapper.BasicCardMapper;
import com.backend.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:14
 */

@Service
public class BasicCardServiceImpl implements BasicCardService {

    @Autowired
    private BasicCardMapper basicCardMapper;
    @Override
    public List<Map<String, Object>> getAssessRecord(Map<String, Object> map) {
        return basicCardMapper.getAssessRecordByBridgeNo(map);
    }

    @Override
    public List<Map<String, Object>> getMaintainRecord(Map<String, Object> map) {
        return basicCardMapper.getMaintainRecordByBridgeNo(map);
    }
}
