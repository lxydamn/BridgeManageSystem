package com.backend.mapper;

import com.backend.pojo.UnitJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UnitJobMapper {

    void insertOne(Map<String, Object> map);

    void insertByUnitJob(UnitJob job);

    Integer getUnitJobData (Map<String, Object> map);
}
