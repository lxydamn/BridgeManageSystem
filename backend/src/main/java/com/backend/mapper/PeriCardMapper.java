package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PeriCardMapper {
    Map<String, Object> getInitCardInfo(Map<String, Object> map);

    Map<String, Object> getBuildTime(Map<String, Object> map);

    Map<String, Object> getCetCpn(String cetPartNo);

    List<Map<String, Object>> getStructRecord(Map<String, Object> map);

    List<Map<String, Object>> getAllStructRecord2();

    List<String> getPeriCardBridgeNo();

    void insertStructRecord(Map<String, Object> map);

    void deleteStructRecord(Map<String, Object> map);

    void insertPeriCard(Map<String, Object> map);

    Map<String, Object> getPeriCard(Map<String, Object> map);
}

