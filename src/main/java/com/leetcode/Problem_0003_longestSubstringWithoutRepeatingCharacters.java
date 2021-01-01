package com.leetcode;

/**
 * 找出无重复字符的子串的长度
 * 类似子串、子序列的问题可以尝试的思路：（i位置结尾的字符的子串来判断）
 * 通过i位置向前推导子串的长度，记录两个关键点
 * 1、i位置字符上一次出现的位置
 * 2、i-1（结尾的信息）位置能达到的最长子串的长度
 * 比较这两个点，找到i位置能够向前推进的最大距离，哪个距离i近，说明那个就是i能到达的最远的距离
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class Problem_0003_longestSubstringWithoutRepeatingCharacters {

    public static int longestSubstringWithoutRepeatingChatacters(String str){
        if(str == null || str == ""){
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];//value记录i位置上的字符最近一次出现的位置 256 ASCII码
        for(int i=0;i<map.length;i++){
            map[i] = -1;//每个字符上一次出现在-1位置
        }
        //以上都是初始化数据，下面开始遍历数组计算
        int len = 0;//收集答案
        int pre = -1;//前一个位置,i-1位置的字符往左能够到达的最远的位置
        int cur = 0;//当前位置上的字符能够到达的最远位置
        for(int i = 0; i != chas.length; i++){
            //比较前一个能够到达的最远的位置和上一次出现该字符出现的位置， 大的值，对应距离i最近的那个
            pre = Math.max(pre, map[i]);//更新成i结尾的信息
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
}
