package com.backend.service;

import com.alibaba.fastjson2.JSONArray;

import java.util.Map;

public interface PeriCardService {
    Map<String, Object> getInitCardInfo(Map<String, Object> map);

    Map<String, Object> getBuildTime(Map<String, Object> map);

    JSONArray getStructRecord(Map<String, Object> map);
}
