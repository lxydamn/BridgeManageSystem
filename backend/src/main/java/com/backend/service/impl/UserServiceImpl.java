package com.backend.service.impl;

import com.backend.mapper.UnitMapper;
import com.backend.mapper.UserMapper;
import com.backend.pojo.Unit;
import com.backend.pojo.User;
import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public Map<String, String> register(Map<String, String> map) {

        Map<String, String> resp = new HashMap<>();

        Integer unit_no = Integer.valueOf(map.get("unit_no"));
        String username = map.get("username");
        String password = map.get("password");
        String tellphone = map.get("tellphone");
        System.out.println(map);

        User user  = userMapper.getUserByUsername(username);

        if (user != null) {
            resp.put("error_info", "用户名重复");
            return resp;
        }
        try {
            userMapper.insertOne(new User(
                    null,
                        unit_no,
                        password,
                        username,
                        tellphone
                    ));

        } catch (Exception e) {
            resp.put("error_info", "错误");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public List<Map<String, Object>> getUsers() {
        return userMapper.getAll();
    }

    @Override
    public Map<String, String> login(Map<String, String> map) {

        Map<String, String> resp = new HashMap<>();

        Integer account = Integer.valueOf(map.get("account"));
        String password = map.get("password");

        User user = userMapper.getUser(account);

        if (user == null) {
            resp.put("error_info", "账号不存在");
            return resp;
        }

        if (!user.getPassword().equals(password)) {
            resp.put("error_info", "密码错误");
            return resp;
        }

        Unit unit = unitMapper.getUnit(user.getUnit_no());
        resp.put("error_info", "success");
        resp.put("username", user.getUsername());
        resp.put("unit_no", String.valueOf(unit.getUnit_no()));
        resp.put("unit_name", unit.getUnit_name());

        return resp;
    }

    @Override
    public Map<String, String> deleteOne(Map<String, String> map) {
        Map<String, String> resp = new HashMap<>();
        Integer account = Integer.parseInt(map.get("account"));
        try {
            userMapper.deleteOne(account);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> update(Map<String, String> map) {
        Map<String, String> resp = new HashMap<>();
        try {
            userMapper.update(map);
        } catch (Exception e) {
            resp.put("error_info", "修改失败");
            return resp;
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, Object> getUUCount() {

        Map<String, Object> resp = new HashMap<>();

        resp.put("user_count", userMapper.getCount());
        resp.put("unit_count", unitMapper.getCount());

        return resp;
    }
}
