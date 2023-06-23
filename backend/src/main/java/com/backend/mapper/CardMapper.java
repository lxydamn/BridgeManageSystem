package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Lxy on 2023/6/23 19:08
 */

@Mapper
@Repository
public interface CardMapper {

    Integer getBasicCardCount();
    Integer getInitCardCount();
    Integer getPeriCardCount();

    Integer getBridgeCount();
}
