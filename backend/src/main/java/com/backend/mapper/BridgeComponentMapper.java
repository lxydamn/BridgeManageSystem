package com.backend.mapper;

import com.backend.pojo.BridgeCpn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeComponentMapper {
    List<Map<String,Object>> getAll();

    void insert(Map<String, Object> map);

    void  delete(Map<String, Object> map);

    void update(Map<String, Object> map);
}
