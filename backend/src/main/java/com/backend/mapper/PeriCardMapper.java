package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PeriCardMapper {
    Map<String, Object> getInitCardInfo(Map<String, Object> map);

    Map<String, Object> getBuildTime(Map<String, Object> map);

    List<Map<String, Object>> getCetCpn(Map<String, Object> map);
}
