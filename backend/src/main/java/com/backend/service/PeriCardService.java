package com.backend.service;

import com.alibaba.fastjson2.JSONArray;

import java.util.List;
import java.util.Map;

public interface PeriCardService {
    Map<String, Object> getInitCardInfo(Map<String, Object> map);
    Map<String, Object> getBuildTime(Map<String, Object> map);
    JSONArray getStructRecord(Map<String, Object> map);
    Map<String, String> insertStructRecord(Map<String, Object> map);
    List<Map<String, Object>> getStructRecord2(Map<String, Object> map);
    Map<String, String> deleteStructRecord(Map<String, Object> map);
    Map<String, String> addPeriCard(Map<String, Object> map);
    Map<String, Object> getPeriCard(Map<String, Object> map);
}
