package com.backend.service;

import com.backend.pojo.Route;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 10:27
 */


public interface RouteService {
    Map<String, String> addRoute(Map<String, Object> map);

    Map<String, Object> getByBridgeNo (Map<String, Object> map);
    Map<String, String> deleteRoute(Map<String, Object> map);

    Map<String, String> updateRoute(Map<String, Object> map);

    List<Route> getAll();

    Route getById(Map<String, Object> map);

    Map<String, Object> getRouteCount();
}
