package com.backend.mapper;

import com.backend.pojo.Route;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 10:30
 */
@Mapper
@Repository

public interface RouteMapper {

    void insert(Map<String, Object> map);
    void update(Map<String, Object> map);

    List<Route> getAll();
    Route selectById(Map<String, Object> map);

    Map<String, Object> selectByBridgeNo(Map<String, Object> map);
    void  delete(Map<String, Object> map);

    Map<String, Object> getRouteCount();
}
