package com.backend.service.impl;

import com.backend.mapper.CardMapper;
import com.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/23 19:13
 */

@Service
public class CardServiceImpl implements CardService {


    @Autowired
    private CardMapper cardMapper;

    @Override
    public Map<String, Object> getCardCount() {
        Map<String, Object> resp = new HashMap<>();

        resp.put("bridge_count", cardMapper.getBridgeCount());
        resp.put("basic_count", cardMapper.getBasicCardCount());
        resp.put("init_count", cardMapper.getInitCardCount());
        resp.put("peri_count", cardMapper.getPeriCardCount());

        return resp;
    }
}
