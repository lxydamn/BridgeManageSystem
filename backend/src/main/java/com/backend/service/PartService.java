package com.backend.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 15:28
 */
public interface PartService {

    JSONArray getStructInfo(Map<String, Object> map);
}
