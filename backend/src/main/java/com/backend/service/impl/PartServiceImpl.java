package com.backend.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.backend.mapper.PartMapper;
import com.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Lxy on 2023/6/24 15:31
 */

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartMapper partMapper;

    @Override
    public JSONArray getStructInfo(Map<String, Object> map) {



        Map<String, Set<String>> partToCpn = new HashMap<>();
        Map<String, List<Map<String, Object>>> cpnToInfo = new HashMap<>();

        String bridgeNo = (String) map.get("bridge_no");

        List<Map<String, Object>> partMF = partMapper.getPartMF(bridgeNo);

        /*
            构造出结构信息树，转化位JSON字符串
         */
        for (Map<String, Object> item : partMF) {

            String cetPartNo =  String.valueOf(item.get("cet_part_no"));

            Map<String, Object> cpnByCetCpn = partMapper.getCpnByCetCpn(cetPartNo);

            String briPartNo = String.valueOf(cpnByCetCpn.get("bri_part_name"));
            String briCpnNo = String.valueOf(cpnByCetCpn.get("bri_cpn_name"));

            partToCpn.putIfAbsent(briPartNo, new HashSet<>());
            partToCpn.get(briPartNo).add(briCpnNo);

            cpnToInfo.putIfAbsent(briCpnNo, new ArrayList<>());
            cpnToInfo.get(briCpnNo).add(item);
        }
        /*
          解构树信息，构造JSON
         */
        JSONArray jsonObject = new JSONArray();
        for (Map.Entry<String, Set<String>> entry : partToCpn.entrySet()) {
            Set<String> cpns = entry.getValue();
            JSONObject mainObject = new JSONObject();
            JSONArray subObject = new JSONArray();
            for (String cpn : cpns) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.addAll(cpnToInfo.get(cpn));
                JSONObject object = new JSONObject();
                object.put("subName", cpn);
                object.put("subArr", jsonArray);
                subObject.add(object);
            }
            mainObject.put("struct", entry.getKey());
            mainObject.put("subStruct", subObject);
            jsonObject.add(mainObject);
        }


        return jsonObject;
    }
}
