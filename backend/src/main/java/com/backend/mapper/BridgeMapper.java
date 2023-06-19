package com.backend.mapper;

import com.backend.pojo.BridgeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeMapper {

    Map<String, Object> getCountByUnit(Map<String, Object> map);
    void insert(Map<String, String> map);
    BridgeInfo selectById(Map<String, String> map);

    List<Map<String, Object>> getAll();

    void update(Map<String, Object> map);
}
