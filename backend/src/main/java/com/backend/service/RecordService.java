package com.backend.service;

import com.backend.pojo.AssessRecord;
import com.backend.pojo.MaintainRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/25 20:06
 */
public interface RecordService {


    Map<String, String> insertAssessRecord(Map<String, Object> map);

    Map<String, String> insertMaintainRecord(Map<String, Object> map);

    Map<String, String> deleteAssessRecord(Map<String, Object> map);

    Map<String, String> deleteMaintainRecord(Map<String, Object> map);

    List<Map<String ,Object>> getAssessRecordWithBS();

    List<Map<String ,Object>> getMaintainRecordWithBS();

    List<Map<String, Object>> getBridgeToCard();

    Map<String, Object> getRecordDataCount();
}
