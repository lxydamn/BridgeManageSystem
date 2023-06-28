package com.backend.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:13
 */
public interface BasicCardService {

    /**
     * 传入桥梁编号
     * 获取桥梁检测历史记录
     */
    List<Map<String, Object>> getAssessRecord(Map<String, Object> map);
    /**
     * 传入桥梁编号
     * 获取桥梁养护处治记录
     */
    List<Map<String, Object>> getMaintainRecord(Map<String, Object> map);

    /**
     * 上传保存卡片数据
     */
    Map<String,String> submitData (Map<String, Object> map);

    /**
     * 获取卡片数据
     */
    Map<String, Object> getBasicCardData(Map<String, Object> map);

    Map<String, Object> getTechIndexData(Map<String, Object> map);

    Map<String, Object> getBridgeFileData(Map<String, Object> map);



    Map<String, Object> getUnitJob(Map<String, Object> map);

    Map<String, Object> getInitCardData(Map<String, Object> map);
}
