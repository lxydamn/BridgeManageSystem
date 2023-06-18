package com.backend.service;

import com.backend.pojo.BridgeType;
import com.backend.pojo.Route;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 19:56
 */

public interface BridgeTypeService {
    Map<String, String> addRoute(Map<String, Object> map);

    Map<String, String> deleteRoute(Map<String, Object> map);

    Map<String, String> updateRoute(Map<String, Object> map);

    List<BridgeType> getAll();

    BridgeType getById(Map<String, Object> map);
}
