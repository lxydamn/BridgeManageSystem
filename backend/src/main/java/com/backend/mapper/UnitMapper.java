package com.backend.mapper;

import com.backend.pojo.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UnitMapper {

    Unit getUnit(Integer unit_no);

    List<Unit> getAll();
    void insertOne(Map<String, String> map);
}
