package com.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public void testJoin(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        String join = StringUtils.join(set.iterator(), ",");
        System.out.println(join);
    }

    public void stringToLong(){
        String  val= "12345678901234567";
        Long l = Long.valueOf(val);
        Long l1 = 12345678901234567L;
        System.out.println(l);
        System.out.println(l1);
        JSONObject object = new JSONObject();
        object.put("id", l1);
        System.out.println(object.toJSONString());
    }

    public void testMatch(){
        String  str = "1AAXXE123";
        String reg = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        System.out.println(mat.matches());
    }

    public void testStringFormat(){
        String s = "【考试范围:%s】已经创建%s，只允许创建一个";
        System.out.println(String.format(s, 123, "考试"));
    }

    public static void main(String[] args) {
        StringTest test = new StringTest();
        test.testJoin();
        test.stringToLong();
        test.testMatch();
        test.testStringFormat();
    }
}
