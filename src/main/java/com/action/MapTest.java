package com.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public void mapToJson(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "jaja");
        map.put(3,"jls");

        System.out.println(JSONObject.toJSONString(map));
    }

    public static void main(String[] args) {
        MapTest test = new MapTest();
        test.mapToJson();
    }
}
