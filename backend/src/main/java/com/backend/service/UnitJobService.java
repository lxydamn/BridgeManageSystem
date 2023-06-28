package com.backend.service;

import java.util.Map;

public interface UnitJobService {

    /**
     * 内部接口
     * 传入单位编号、桥梁编号、职责
     *  成功返回{error_info : success}
     *  失败返回{error_info : 错误消息}
     */
    Map<String, String> addUnitJob(Map<String, Object> map);
}
