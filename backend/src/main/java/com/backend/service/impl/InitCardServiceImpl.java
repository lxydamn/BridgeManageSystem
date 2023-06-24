package com.backend.service.impl;

import com.backend.mapper.InitCardMapper;
import com.backend.service.InitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InitCardServiceImpl implements InitCardService {

    @Autowired
    InitCardMapper initCardMapper;

    @Override
    public Map<String, String> addInitCard(Map<String, String> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            initCardMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }
}
