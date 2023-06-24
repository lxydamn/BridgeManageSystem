package com.backend.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:13
 */
public interface BasicCardService {
    List<Map<String, Object>> getAssessRecord(Map<String, Object> map);
    List<Map<String, Object>> getMaintainRecord(Map<String, Object> map);
}
