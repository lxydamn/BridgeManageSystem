package com.backend.mapper;

import com.backend.pojo.BridgeType;
import com.backend.pojo.Route;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 19:54
 */

@Mapper
@Repository
public interface BridgeTypeMapper {

    void insert(Map<String, Object> map);
    void update(Map<String, Object> map);
    List<Map<String, Object>> getTypeCount();
    List<BridgeType> getAll();
    BridgeType selectById(Map<String, Object> map);
    void delete(Map<String, Object> map);
    Integer getTypeCpnCount(String type_no);
}
