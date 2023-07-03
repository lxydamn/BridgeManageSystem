package com.backend.service;

import java.util.List;
import java.util.Map;

public interface BridgeCetPartService {
    List<Map<String, Object>> getCetPartStatus(Map<String, Object> map);
    List<Map<String,Object>> getAll(Map<String, Object> map);
    Map<String, String> addCetPart(Map<String, Object> map);
    Map<String, String> deleteCetPart(Map<String, Object> map);
    Map<String, String> updateCetPart(Map<String, Object> map);
}
