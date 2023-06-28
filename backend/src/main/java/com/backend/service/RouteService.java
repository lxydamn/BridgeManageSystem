package com.backend.service;

import com.backend.pojo.Route;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 10:27
 */


public interface RouteService {

    /**
     * 添加路线
     * 传入路线相关参数
     * 成功返回 {error_info : success}
     * 失败返回 {error_info : 错误消息}
     */
    Map<String, String> addRoute(Map<String, Object> map);

    /**
     * 删除路线
     * 传入路线的编号
     * 成功返回 {error_info : success}
     * 失败返回 {error_info : 错误信息}
     */
    Map<String, String> deleteRoute(Map<String, Object> map);

    /**
     * 添加路线
     * 传入路线相关参数
     * 成功返回 {error_info : success}
     * 失败返回 {error_info : 错误消息}
     */
    Map<String, String> updateRoute(Map<String, Object> map);


    /**
     * 返回系统中所有的路线数据
     */
    List<Route> getAll();

    Route getById(Map<String, Object> map);

    /**
     * 获取路线的数量
     */
    Map<String, Object> getRouteCount();

    Map<String, Object> getByBridgeNo (Map<String, Object> map);
}
