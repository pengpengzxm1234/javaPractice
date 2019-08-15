package com.algorithm.longestPalindrome;

import org.springframework.util.StringUtils;

/**
 * 最长回文子串——暴力法
 * @Desc 该方法是将以每个字符为首的子串都遍历一遍，
 * 判断是否为回文，如果是回文，再判断最大长度的回文子串。
 * 算法简单，但是算法复杂度太高，O（n^3）
 */
public class LongestPalindromeForce {

    public String longestPalindromeForce(String source){
        if(StringUtils.isEmpty(source)){
            return "";
        }
        if(1 == source.length()){
            return source;
        }
        char[] s = source.toCharArray();
        int start = 0, maxLength =1;
        for(int i=0; i< s.length; i++){
            for(int j=i+1; j < s.length; j++){
                int temp1, temp2;
                for(temp1 = i, temp2 = j; temp1 < temp2; temp1++, temp2--){
                    if(s[temp1] != s[temp2]){
                        break;
                    }
                }
                System.out.println("temp1:" + temp1 + " temp2:" + temp2);
                if(temp1 >= temp2 && j-i+1>maxLength){
                    maxLength = j-i+1;
                    start = i;
                }
            }
        }

        return source.substring(start, maxLength);
    }

    public static void main(String[] args){
        String str = "abba";
        LongestPalindromeForce longestPalindromeForce = new LongestPalindromeForce();
        System.out.println("暴力法——最长回文子串是：" + longestPalindromeForce.longestPalindromeForce(str));
    }
}
