package com.backend.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 15:28
 */
public interface PartService {

    /**
     * 获取桥梁结构数据
     * 传入桥梁编号，自动生成Json字符串
     * [
     *  struct: {
     *      name: xxx
     *      subStruct : [
     *          {
     *              subName: xxx
     *              subArr: [x, x, x...]
     *          }
     *      ]
     *  }
     * ]
     */
    JSONArray getStructInfo(Map<String, Object> map);
}
