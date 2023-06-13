package com.backend.service;

import java.util.Map;

public interface UserService {
    Map<String, String> register(Map<String, String> map);

    Map<String, String> login(Map<String, String> map);
}
