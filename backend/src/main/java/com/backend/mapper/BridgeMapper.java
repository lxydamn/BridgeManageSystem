package com.backend.mapper;

import com.backend.pojo.BridgeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BridgeMapper {

    void insert(Map<String, String> map);
    BridgeInfo selectById(Map<String, String> map);


}
