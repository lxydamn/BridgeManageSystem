package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface InitCardMapper {
    void insertInitCard(Map<String, Object> map);

    Map<String, Object> getInitCard(Map<String, Object> map);
}
