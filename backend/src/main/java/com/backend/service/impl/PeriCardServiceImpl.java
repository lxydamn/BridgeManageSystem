package com.backend.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.backend.mapper.PeriCardMapper;
import com.backend.service.PeriCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PeriCardServiceImpl implements PeriCardService {
    @Autowired
    PeriCardMapper periCardMapper;

    @Override
    public Map<String, Object> getInitCardInfo(Map<String, Object> map) {
        return periCardMapper.getInitCardInfo(map);
    }

    @Override
    public Map<String, Object> getBuildTime(Map<String, Object> map) {
        System.out.println(periCardMapper.getBuildTime(map));
        return periCardMapper.getBuildTime(map);
    }

    @Override
    public JSONArray getStructRecord(Map<String, Object> map) {
        System.out.println(periCardMapper.getCetCpn(map));
        return null;
    }
}
