package com.backend.service;

import com.backend.pojo.BridgeInfo;

import java.util.List;
import java.util.Map;

public interface BridgeService {
    Map<String, String> addBridge(Map<String, String> map);

    BridgeInfo getBridge(Map<String, String> map);

    List<Map<String, Object>> getAll();
}
