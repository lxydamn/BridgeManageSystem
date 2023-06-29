package com.backend.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.backend.mapper.PeriCardMapper;
import com.backend.service.PeriCardService;
import com.backend.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeriCardServiceImpl implements PeriCardService {
    @Autowired
    PeriCardMapper periCardMapper;

    @Override
    public Map<String, Object> getInitCardInfo(Map<String, Object> map) {
        return periCardMapper.getInitCardInfo(map);
    }

    @Override
    public Map<String, Object> getBuildTime(Map<String, Object> map) {
        System.out.println(periCardMapper.getBuildTime(map));
        return periCardMapper.getBuildTime(map);
    }

    @Override
    public JSONArray getStructRecord(Map<String, Object> map) {
        Map<String, List<Map<String, Object>>> structRecordInfo = new HashMap<>();
        Map<String, Set<String>> partToCet = new HashMap<>();

        List<Map<String, Object>> structRecord = periCardMapper.getStructRecord(map);

        for (Map<String, Object> item : structRecord) {
            String cetPartNo = String.valueOf(item.get("cet_part_no"));
            Map<String, Object> getPartName = periCardMapper.getCetCpn(cetPartNo);

            String partName = String.valueOf(getPartName.get("bri_part_name"));
            String cetPartName = String.valueOf(item.get("cet_part_name"));

            partToCet.putIfAbsent(partName, new HashSet<>());
            partToCet.get(partName).add(cetPartName);

            structRecordInfo.putIfAbsent(cetPartName, new ArrayList<>());
            structRecordInfo.get(cetPartName).add(item);
        }

        JSONArray jsonObject = new JSONArray();
        for (Map.Entry<String, Set<String>> entry : partToCet.entrySet()) {
            Set<String> cetParts = entry.getValue();
            String partName = entry.getKey();
            JSONObject partObject = new JSONObject();
            partObject.put("partName", partName);
            JSONArray cetPartObject = new JSONArray();
            for (String cetPart : cetParts) {
                cetPartObject.addAll(structRecordInfo.get(cetPart));
            }
            partObject.put("cetParts",cetPartObject);
            jsonObject.add(partObject);
        }

        return jsonObject;
    }

    @Override
    public Map<String, String> insertStructRecord(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        String stru_rcd_no = UIDUtil.getUUNumber(8);
        try {
            map.put("stru_rcd_no", stru_rcd_no);
            periCardMapper.insertStructRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "添加失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public List<Map<String, Object>> getStructRecord2() {
        List<Map<String, Object>> structRecord = new ArrayList<>();
        List<Map<String, Object>> allStructRecord = periCardMapper.getAllStructRecord2();
        List<String> periCardBridgeNo = periCardMapper.getPeriCardBridgeNo();

        for (Map<String, Object> str : allStructRecord) {
            String bridgeNo = (String) str.get("bridge_no");
            if(!periCardBridgeNo.isEmpty()) {
                for(String tempNo : periCardBridgeNo){
                    if (!bridgeNo.equals(tempNo)) {
                        structRecord.add(str);
                    }
                }
            } else {
                structRecord = allStructRecord;
            }

        }
        return structRecord;
    }

    @Override
    public Map<String, String> deleteStructRecord(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();

        try {
            periCardMapper.deleteStructRecord(map);
        } catch (Exception e) {
            resp.put("error_info", "删除失败");
        }
        resp.putIfAbsent("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, String> addPeriCard(Map<String, Object> map) {
        Map<String, String> resp = new HashMap<>();
        String bridge_no = (String) map.get("bridge_no");
        map.remove("bridge_no");
        String periRecordNo = UIDUtil.getUUID(12);

        try {
            for (Map.Entry<String, Object> item : map.entrySet()) {
                Map<String, Object> data = JSONObject.parse(String.valueOf(item.getValue()));

                data.put("peri_record_no", periRecordNo);
                data.put("bridge_no", bridge_no);
                data.replace("las_rema_time", data.get("las_rema_time").toString().substring(0, 10));
                data.replace("las_insp_time", data.get("las_insp_time").toString().substring(0, 10));
                data.replace("now_insp_time", data.get("now_insp_time").toString().substring(0, 10));
                data.replace("nex_insp_time", data.get("nex_insp_time").toString().substring(0, 10));
                periCardMapper.insertPeriCard(data);
            }
        } catch (Exception e) {
            System.out.println(e);
            resp.put("error_info", "error");
            return resp;
        }

        resp.put("error_info", "success");
        return resp;
    }

    @Override
    public Map<String, Object> getPeriCard(Map<String, Object> map) {
        return periCardMapper.getPeriCard(map);
    }
}
