package com.backend.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/25 19:47
 */

@Mapper
@Repository
public interface RecordMapper {
    void insertAssessRecord(Map<String, Object> map);
    void deleteAssessRecord(Map<String, Object> map);

    void insertMaintainRecord(Map<String, Object> map);

    void deleteMaintainRecord(Map<String, Object> map);

    List<Map<String, Object>> getAssessRecordWithBC();
    List<Map<String, Object>> getMaintainRecordWithBC();

    List<Map<String, Object>> getBridgeToCard();

    Integer assessRecordCount();
    Integer maintainRecordCount();

    Integer partCount();

    Integer componentCount();

    Integer typeCpmCount();
}
