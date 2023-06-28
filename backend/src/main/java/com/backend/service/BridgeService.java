package com.backend.service;

import com.backend.pojo.BridgeInfo;

import java.util.List;
import java.util.Map;

public interface BridgeService {

    /**
     * 添加桥梁
     *  若数据正常，能正常添加，则返回{error_info:success}
     *  若数据错误，不能正常添加，则返回{error_info：相关错误信息}
     */
    Map<String, String> addBridge(Map<String, Object> map);


    BridgeInfo getBridge(Map<String, String> map);

    /**
     * 传入单位编号
     * 返回桥梁的基本信息
     * 编号、名称、路线、类型、经纬度
     */
    List<Map<String , Object>> getBridgeLL(Map<String, String> map);

    /**
     * 根据前端传入的用户单位返回所有的桥梁相关数据
     */
    List<Map<String, Object>> getAllByUnitNo(Map<String, Object> map);

    Map<String, Object> getCountByUnit(Map<String, Object> map);

    /**
     *   修改桥梁
     *  若数据正常，能正常修改，则返回{error_info:success}
     *  若数据错误，不能正常修改，则返回{error_info：相关错误信息}
     */
    Map<String, String> updateBridge(Map<String, Object> map);

    List<Map<String, Object>> getCardStatus(Map<String, Object> map);


}
