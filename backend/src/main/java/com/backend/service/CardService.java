package com.backend.service;

import java.util.Map;

/**
 * Created by Lxy on 2023/6/23 19:13
 */
public interface CardService {

    /**
     * 获取桥梁、基本卡片、初始检查、定期检查数量
     */
    Map<String, Object> getCardCount();
}
