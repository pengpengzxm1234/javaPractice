package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode高频讲解三
 * 2-9数字上映射的英文字母
 * 给定两个数，输出数字中包含的所有的两个字母的组合
 * 如 输入2，3
 * 输出 【“ad”，“ae”，“af”，“bd”，“be”，“bf”，“dc”,"ce","cf"】
 * 最优解：暴力递归
 *   递归数字‘2’上所有字母对上数字‘3’上字母的情况，得到所有组合
 */
public class Problem_0017_LetterCombinationsOfAPhoneNumber {
    public static char[][] phone = {
            {'a','b','c'},//2
            {'d','e','f'},//3
            {'g','h','i'},//4
            {'j','k','l'},//5
            {'m','n','o'},//6
            {'p','q','r','s'},//7
            {'t','u','v'},//8
            {'w','x','y','z'}//9
    };

    public static List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        if(digits == null || digits == ""){
            return ans;
        }

        char[] str = digits.toCharArray();
        char[] path = new char[str.length];
        process(str, 0, path, ans);
        return ans;
    }

    //str = ['2','3']
    //str[...index - 1]，按出的结果都放入path中
    //str[index] 按完之后，有哪些组合，放入到ans中
    public static void process(char[] str, int index, char[] path, List<String> ans){
        if(index == str.length){//path填满，手机答案到ans
            ans.add(String.valueOf(path));
        }else {
            char[] cands = phone[str[index] - '2'];//按键对应字母的数组
            for(char cur : cands){
                path[index] = cur;
                process(str, index +1, path, ans);
            }
        }
    }

}
