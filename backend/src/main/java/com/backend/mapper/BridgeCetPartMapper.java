package com.backend.mapper;

import com.backend.pojo.BridgeCetPart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeCetPartMapper {
    Integer getCetPartCount(String type_no);

    List<BridgeCetPart> getAll(Map<String,Object> map);

    void insert(Map<String, Object> map);

    void delete(Map<String, Object> map);

    void update(Map<String, Object> map);
}
