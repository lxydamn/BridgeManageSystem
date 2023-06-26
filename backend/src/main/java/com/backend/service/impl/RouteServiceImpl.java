package com.backend.service.impl;

import com.backend.mapper.RouteMapper;
import com.backend.pojo.Route;
import com.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 10:29
 */

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public Map<String, String> addRoute(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();

        try {
            routeMapper.insert(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public Map<String, Object> getByBridgeNo(Map<String, Object> map) {
        return routeMapper.selectByBridgeNo(map);
    }

    @Override
    public Map<String, String> deleteRoute(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            routeMapper.delete(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }

        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> updateRoute(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            routeMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public List<Route> getAll() {

        return routeMapper.getAll();
    }

    @Override
    public Route getById(Map<String, Object> map) {
        return routeMapper.selectById(map);
    }

    @Override
    public Map<String, Object> getRouteCount() {
        return routeMapper.getRouteCount();
    }
}
