package com.leetcode;

/**
 * leetcode高频讲解三
 * 字符串最长公共前缀
 * 取出第一个字符串，遍历其字符串字符，遍历要不同时break，并对比找到最小值
 */
public class Problem_0014_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        char[] chs = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        for(String str :strs){
            char[] temp = str.toCharArray();
            int index = 0;
            while (index < temp.length && index < chs.length){
                if(temp[index] != chs[index]){
                    break;
                }
                index++;
            }
            min = Math.min(min, index);
            if(min == 0){
                return "";
            }
        }
        return strs[0].substring(0, min);
    }
}
