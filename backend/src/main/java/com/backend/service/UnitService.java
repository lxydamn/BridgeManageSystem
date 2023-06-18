package com.backend.service;

import com.backend.pojo.Unit;

import java.util.List;
import java.util.Map;

public interface UnitService {
    Map<String, String> addUnit(Map<String, String> map);
    List<Unit> getAll();

    Map<String, String> delete(Map<String , String> map);

    Map<String, String> update(Map<String, String> map);
}
