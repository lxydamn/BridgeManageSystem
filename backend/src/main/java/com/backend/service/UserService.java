package com.backend.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 添加用户接口
     * 若添加成功返回 {error_info: success}
     * 若添加失败返回 {error_info : “ 添加失败 ” }
     */
    Map<String, String> register(Map<String, String> map);

    /**
     * 返回系统中所有用户的信息
     */
    List<Map<String, Object>> getUsers();

    /**
     *  检查用户的账号密码
     *  若账号密码错误则返回 {error_info : " 错误类型 "}
     *  若账号密码正确则返回 {error_info : " success" }
     *  成功之后还会携带 用户名、单位编号、单位名称
     */
    Map<String, String> login(Map<String, String> map);

    /**
     * 删除用户接口
     * 若添加成功返回 {error_info: success}
     * 若添加失败返回 {error_info : “删除失败 ” }
     */
    Map<String, String> deleteOne(Map<String, String> map);

    /**
     * 修改用户接口
     * 若添加成功返回 {error_info: success}
     * 若添加失败返回 {error_info : “修改失败” }
     */
    Map<String, String> update(Map<String, String> map);

    /**
     * 获取用户和单位的数量
     */
    Map<String, Object> getUUCount();
}
