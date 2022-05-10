package com.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public void mapToJson(){
        HashMap<Integer, String> map = new HashMap<>();
        int i = 0;
        while (i < 1000){
            map.put(i, String.valueOf(i));
            i++;
        }


        System.out.println(JSONObject.toJSONString(map));
    }

    public static void main(String[] args) {
        MapTest test = new MapTest();
        test.mapToJson();
    }
}
