package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 15:01
 */

@Mapper
@Repository
public interface PartMapper {

    List<Map<String, Object>> getPartMF(String bridge_no);

    Map<String, Object> getCpnByCetCpn(String cet_part_no);

}
