package com.backend.service;

import com.backend.pojo.BridgeCpn;
import com.backend.pojo.BridgePart;

import java.util.List;
import java.util.Map;

public interface BridgeComponentService {
    Map<String, String> addComponent(Map<String, Object> map);

    List<BridgeCpn> getAll();

    Map<String, String> deleteComponent(Map<String, Object> map);

    Map<String, String> updateComponent(Map<String, Object> map);
}
