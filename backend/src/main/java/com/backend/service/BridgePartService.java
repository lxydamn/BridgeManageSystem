package com.backend.service;

import com.backend.pojo.BridgePart;
import com.backend.pojo.BridgeType;

import java.util.List;
import java.util.Map;

public interface BridgePartService {
    Map<String, String> addPart(Map<String, Object> map);

    List<BridgePart> getAll();

    Map<String, String> deletePart(Map<String, Object> map);

    Map<String, String> updatePart(Map<String, Object> map);
}
