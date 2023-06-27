package com.backend.mapper;

import com.backend.pojo.BridgeInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeMapper {

    Integer getBasicCardCount(Map<String, Object> map);

    Integer getInitRecordCount(Map<String, Object> map);

    Integer getPeriRecordCount(Map<String, Object> map);

    Integer getBasicCardCountByBridgeNo(String bridge_no);

    Integer getInitCardCountByBridgeNo(String bridge_no);

    Integer getPeriCardCountByBridgeNo(String bridge_no);

    List<BridgeInfo> getBridgeByUnit(Map<String, Object> map);


    Map<String, Object> getAllCount(Map<String, Object> map);

    Map<String, Object> getBridgeInfoAndAbout(String bridge_no);

    Integer getCountByUnit(Map<String, Object> map);
    void insert(Map<String, Object> map);
    BridgeInfo selectById(Map<String, String> map);
    List<Map<String, Object>> getAll();
    void update(Map<String, Object> map);

    void updateBridgeLL(Map<String, Object> map);

    Map<String, Object> getBridgeLL(String bridge_no);

    void insertLL(Map<String, Object> map);

}
