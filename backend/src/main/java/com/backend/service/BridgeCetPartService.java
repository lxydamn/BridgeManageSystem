package com.backend.service;

import com.backend.pojo.BridgeCetPart;

import java.util.List;
import java.util.Map;

public interface BridgeCetPartService {
    List<Map<String, Object>> getCetPartStatus(Map<String, Object> map);
    List<BridgeCetPart> getAll(Map<String, Object> map);

    Map<String, String> addCetPart(Map<String, Object> map);

    Map<String, String> deleteCetPart(Map<String, Object> map);

    Map<String, String> updateCetPart(Map<String, Object> map);
}
