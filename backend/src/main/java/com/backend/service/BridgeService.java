package com.backend.service;

import com.backend.pojo.BridgeInfo;

import java.util.List;
import java.util.Map;

public interface BridgeService {
    Map<String, String> addBridge(Map<String, Object> map);

    BridgeInfo getBridge(Map<String, String> map);

    List<Map<String , Object>> getBridgeLL(Map<String, String> map);
    List<Map<String, Object>> getAllByUnitNo(Map<String, Object> map);

    Map<String, Object> getCountByUnit(Map<String, Object> map);

    Map<String, String> updateBridge(Map<String, Object> map);

    List<Map<String, Object>> getCardStatus(Map<String, Object> map);


}
