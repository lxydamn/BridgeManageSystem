package com.backend;

import com.backend.mapper.PartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private PartMapper partMapper;


    @Test
    void contextLoads() {

        List<Map<String, Object>> partMF = partMapper.getPartMF("1");

        for (Map<String, Object> item : partMF) {
            System.out.println(item);
        }
    }

}
