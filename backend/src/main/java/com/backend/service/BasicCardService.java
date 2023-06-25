package com.backend.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:13
 */
public interface BasicCardService {
    List<Map<String, Object>> getAssessRecord(Map<String, Object> map);
    List<Map<String, Object>> getMaintainRecord(Map<String, Object> map);

    Map<String,String> submitData (Map<String, Object> map);

    Map<String, Object> getTechIndexData(Map<String, Object> map);

    Map<String, Object> getBridgeFileData(Map<String, Object> map);

    Map<String, Object> getBasicCardData(Map<String, Object> map);

    Map<String, Object> getUnitJob(Map<String, Object> map);

    Map<String, Object> getInitCardData(Map<String, Object> map);
}
