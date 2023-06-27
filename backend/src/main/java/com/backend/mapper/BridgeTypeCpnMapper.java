package com.backend.mapper;

import com.backend.pojo.BridgePart;
import com.backend.pojo.BridgeTypeCpn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeTypeCpnMapper {
    List<Map<String, Object>> getAll(Map<String, Object> map);

    void insert(Map<String, Object> map);

    void delete(Map<String, Object> map);

    void update(Map<String, Object> map);
}
