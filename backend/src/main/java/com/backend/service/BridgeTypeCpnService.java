package com.backend.service;

import com.backend.pojo.BridgePart;
import com.backend.pojo.BridgeTypeCpn;

import java.util.List;
import java.util.Map;

public interface BridgeTypeCpnService {
    Map<String, String> addTypeCpn(Map<String, Object> map);

    List<BridgeTypeCpn> getAll(Map<String, Object> map);

    Map<String, String> deleteTypeCpn(Map<String, Object> map);

    Map<String, String> updateTypeCpn(Map<String, Object> map);
}
