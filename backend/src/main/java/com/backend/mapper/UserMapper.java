package com.backend.mapper;

import com.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
     User getUser(Integer account);
     void insertOne(User user);

     List<Map<String, Object>> getAll();
     User getUserByUsername(String username);

     void deleteOne(Integer account);
}
