package com.backend.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.backend.mapper.BasicCardMapper;
import com.backend.mapper.UnitJobMapper;
import com.backend.pojo.UnitJob;
import com.backend.service.BasicCardService;
import com.backend.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/24 21:14
 */

@Service
public class BasicCardServiceImpl implements BasicCardService {

    @Autowired
    private BasicCardMapper basicCardMapper;

    @Autowired
    private UnitJobMapper unitJobMapper;

    @Override
    public List<Map<String, Object>> getAssessRecord(Map<String, Object> map) {
        return basicCardMapper.getAssessRecordByBridgeNo(map);
    }

    @Override
    public List<Map<String, Object>> getMaintainRecord(Map<String, Object> map) {
        return basicCardMapper.getMaintainRecordByBridgeNo(map);
    }

    @Override
    @Transactional
    public Map<String, String> submitData(Map<String, Object> map) {

        Map<String, String> resp = new HashMap<>();
        String bridge_no = (String) map.get("bridge_no");
        map.remove("bridge_no");
        String cardNo = UIDUtil.getUUID(12);
        String fileNo = UIDUtil.getUUID(12);

        try {
            for (Map.Entry<String, Object> item : map.entrySet()) {
                System.out.println(item);
                Map<String, Object> data = JSONObject.parse(String.valueOf(item.getValue()));
                if (item.getKey().equals("cardInfo")) {
                    data.put("card_no", cardNo);
                    data.replace("card_time", data.get("card_time").toString().substring(0, 10));
                    data.replace("build_time", data.get("build_time").toString().substring(0, 10));
                    basicCardMapper.insertBasicCard(data);
                } else if (item.getKey().equals("techIndex")) {
                    data.put("card_no", cardNo);
                    data.put("bridge_tech_index", UIDUtil.getUUNumber(8));
                    basicCardMapper.insertTechIndex(data);
                } else if (item.getKey().equals("bridgeFile")) {
                    data.put("card_no", cardNo);
                    data.put("file_no", fileNo);
                    data.replace("file_time", data.get("file_time").toString().substring(0, 10));
                    basicCardMapper.insertBridgeFile(data);
                } else {
                    Integer spr_unit = Integer.parseInt(String.valueOf(data.get("spr_unit")));
                    Integer own_unit = Integer.parseInt(String.valueOf(data.get("own_unit")));
                    UnitJob unitJob = new UnitJob(spr_unit, bridge_no, "监理");
                    unitJobMapper.insertByUnitJob(unitJob);
                    UnitJob unitJob1 = new UnitJob(own_unit, bridge_no, "业主");
                    unitJobMapper.insertByUnitJob(unitJob1);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, Object> getTechIndexData(Map<String, Object> map) {
        return basicCardMapper.getTechIndexData(map);
    }

    @Override
    public Map<String, Object> getBridgeFileData(Map<String, Object> map) {
        return basicCardMapper.getBridgeFileData(map);
    }

    @Override
    public Map<String, Object> getBasicCardData(Map<String, Object> map) {
        return basicCardMapper.getCardInfoData(map);
    }

    @Override
    public Map<String, Object> getUnitJob(Map<String, Object> map) {

        Map<String, Object> resp = new HashMap<>();

        map.put("unit_job", "监理");
        resp.put("spr_unit", unitJobMapper.getUnitJobData(map));
        map.replace("unit_job", "业主");
        resp.put("own_unit",unitJobMapper.getUnitJobData(map));

        return resp;
    }

    @Override
    public Map<String, Object> getInitCardData(Map<String, Object> map) {

        Map<String, Object> initCardData = basicCardMapper.getInitCardData(map);

        map.put("unit_job", "设计");
        initCardData.put("des_unit", unitJobMapper.getUnitJobData(map));
        map.replace("unit_job", "施工");
        initCardData.put("cst_unit", unitJobMapper.getUnitJobData(map));

        return initCardData;
    }
}
