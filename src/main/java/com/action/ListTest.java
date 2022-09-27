package com.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public void testAddNull(){
        List<String> list = new ArrayList<>();
        list.add(null);
        String result = list.stream().filter(StringUtils::isNotBlank).findFirst().orElse(null);
        System.out.println(list.size());
        System.out.println(JSONArray.toJSONString(list));
    }

    public void addFinalList(){
        final List<Integer> list = new ArrayList<>();
        for(int i=0;i< 10;i++){
            list.add(i);
        }
        System.out.println(list.toString());
    }

    public void testSubList(){
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(Long.valueOf(i));
        }
        List<Long> subList = list.subList(0, 20);
        List<Long> sublist1 = list.subList(20, 40);
        List<Long> subList2 = list.subList(100, 100);

        System.out.println(subList.size());
        System.out.println(subList.toString());
        System.out.println(sublist1.size());
        System.out.println(sublist1.toString());
        System.out.println(subList2.toString());
        String str = JSONArray.toJSONString(null);
        System.out.println(StringUtils.isBlank(str));

        Long value = 1L;
        System.out.println(value > 0);
    }

    public static void main(String[] args) {
        ListTest test = new ListTest();
        test.testAddNull();
    }
}
