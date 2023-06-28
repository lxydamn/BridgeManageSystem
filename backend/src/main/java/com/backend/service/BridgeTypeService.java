package com.backend.service;

import com.backend.pojo.BridgeType;
import com.backend.pojo.Route;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 19:56
 */

public interface BridgeTypeService {
    Map<String, String> addType(Map<String, Object> map);

    Map<String, String> deleteType(Map<String, Object> map);

    Map<String, String> updateType(Map<String, Object> map);

    List<BridgeType> getAll();

    BridgeType getById(Map<String, Object> map);

    /**
     * 获取桥梁类型名称、类型数量
     */
    List<Map<String, Object>> getCount();

    List<Map<String, Object>> getTypeCpnStatus();
}
