package com.backend.mapper;

import com.backend.pojo.BridgeInfo;
import org.apache.ibatis.annotations.Mapper;
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

    Integer getCountByUnit(Map<String, Object> map);
    void insert(Map<String, String> map);
    BridgeInfo selectById(Map<String, String> map);

    List<Map<String, Object>> getAll();

    void update(Map<String, Object> map);

    List<Map<String,Object>> getRouteByBridgeNo(Map<String,String> map);
}
