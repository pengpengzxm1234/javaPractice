package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode高频讲解七
 * 找所有同型词，字符类型一样（都出现过n次，都有n个不同字符）
 *
 */
public class Problem_0049_GroupAnagrams {


    //str1 和 str2 按照字符排序，排序后相同，一定是同型词
    //map key：字符串排完序后的字符串， value是一个list，保存原字符列表
    public static List<List<String>> groupAnagrams2(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String  str :strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}
