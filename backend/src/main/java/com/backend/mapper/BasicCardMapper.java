package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 14:42
 */
@Mapper
@Repository
public interface BasicCardMapper {
    List<Map<String, Object>> getAssessRecordByBridgeNo(Map<String, Object> map);
    List<Map<String, Object>> getMaintainRecordByBridgeNo(Map<String, Object> map);

    void insertBasicCard(Map<String, Object> map);

    void insertTechIndex(Map<String, Object> map);

    void insertBridgeFile(Map<String, Object> map);

    Map<String, Object> getCardInfoData(Map<String, Object> map);
    Map<String, Object> getTechIndexData(Map<String, Object> map);

    Map<String, Object> getBridgeFileData(Map<String, Object> map);

    Map<String, Object> getInitCardData(Map<String, Object> map);

}
