package com.backend.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> register(Map<String, String> map);

    List<Map<String, Object>> getUsers();
    Map<String, String> login(Map<String, String> map);

    Map<String, String> deleteOne(Map<String, String> map);
}
