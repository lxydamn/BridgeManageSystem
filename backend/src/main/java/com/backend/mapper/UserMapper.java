package com.backend.mapper;

import com.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
     User getUser(Integer account);
     void insertOne(User user);

     User getUserByUsername(String username);
}
