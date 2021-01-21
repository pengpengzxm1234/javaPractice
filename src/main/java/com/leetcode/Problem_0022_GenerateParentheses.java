package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode高频讲解三
 * 生成所有满足匹配要求的括号组合
 * 如 n = 3，则生成三组小括号 那么足配对的所有组合
 * 即[
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 *
 * 暴力递归
 * 卡特兰数
 *
 */
public class Problem_0022_GenerateParentheses {

    //给定一个n的值，符号的数量一定是2n个
    public static List<String> generateParenthesis(int n){
        char[] path = new char[n * 2];
        List<String> ans = new ArrayList<>();
        process(path, 0, 0, n, ans);
        return ans;
    }


    //一次再path上填写决定,即每个位置上是什么符号
    //( (  ) ) ( )
    //0  1 2 3 4 5
    //path[0...index-1]决定已经做完
    //index位置上所有决定做完，加到结果集合中
    //leftMinusRight 已经做过的决定区域 左减右后剩余的数量（即左括号减右括号，还剩几个右括号后就合法了）
    //leftRest 还剩多少个左括号能用
    //中途减支，提高效率
    public static void process(char[] path, int index, int leftMinusRight, int leftRest, List<String> ans){
        if(index == path.length){
            ans.add(String.valueOf(path));
        }else {
            if(leftRest > 0){
                path[index] = '(';
                process(path, index + 1, leftMinusRight + 1, leftRest - 1, ans);
            }
            if(leftMinusRight > 0){
                path[index] = ')';
                process(path, index + 1, leftMinusRight - 1, leftRest, ans);
            }
        }
    }





    // 不剪枝的做法
    public static List<String> generateParenthesis2(int n) {
        char[] path = new char[n << 1];
        List<String> ans = new ArrayList<>();
        process2(path, 0, ans);
        return ans;
    }

    public static void process2(char[] path, int index, List<String> ans) {
        if (index == path.length) {
            if (isValid(path)) {
                ans.add(String.valueOf(path));
            }
        } else {
            path[index] = '(';
            process2(path, index + 1, ans);
            path[index] = ')';
            process2(path, index + 1, ans);
        }
    }

    public static boolean isValid(char[] path) {
        int count = 0;
        for (char cha : path) {
            if (cha == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }


}
