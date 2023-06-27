package com.backend.service;

import java.util.Map;

public interface InitCardService {
    Map<String, String> addInitCard(Map<String, Object> map);

    Map<String, Object> getUnitJob(Map<String, Object> map);

    Map<String, Object> getInitCard(Map<String, Object> map);
}
