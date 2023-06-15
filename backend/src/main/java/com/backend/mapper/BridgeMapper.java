package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BridgeMapper {

    void insertOne(Map<String, String> map);
}
