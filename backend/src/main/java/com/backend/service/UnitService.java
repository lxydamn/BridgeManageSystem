package com.backend.service;

import com.backend.pojo.Unit;

import java.util.List;
import java.util.Map;

public interface UnitService {

    /**
     * 添加单位
     *  成功则返回 {error_info : success}
     *  失败则返回  {error_info : 错误消息}
     */
    Map<String, String> addUnit(Map<String, String> map);

    /**
     * 获取单位数据
     * 返回系统中的所有的单位
     */
    List<Unit> getAll();

    /**
     * 删除单位
     * 传入待删除单位编号
     *  成功则返回 {error_info : success}
     *  失败则返回  {error_info : 错误消息}
     */
    Map<String, String> delete(Map<String , String> map);

    /**
     * 修改单位
     * 传入待删除单位相关的数据
     *  成功则返回 {error_info : success}
     *  失败则返回  {error_info : 错误消息}
     */
    Map<String, String> update(Map<String, String> map);
}
