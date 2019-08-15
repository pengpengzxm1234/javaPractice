package com.algorithm.longestPalindrome;

import java.util.Vector;

/**
 * 找出最长回文子串——动态规划方法
 * @Desc
 * 对于字符串str，假设dp[i,j]=1表示str[i...j]是回文子串，那个必定存在dp[i+1,j-1]=1。这样最长回文子串就能分解成一系列子问题，可以利用动态规划求解了。
 *   当str[i]=str[j]时，如果str[i+1...j-1]是回文串，则str[i...j]也是回文串；如果str[i+1...j-1]不是回文串，则str[i...j]不是回文串。
 *  初始状态
 *   dp[i][i]=1
 *   dp[i][i+1]=1 if str[i]==str[i+1]
 *   上式的意义是单个字符，两个相同字符都是回文串。
 */
public class LongestPalindromeDp {


    public String longestPalindromeDp(String str){
        if(str.isEmpty()){
            return str;
        }
        if(1 == str.length()){
            return str;
        }
        int length = str.length();
        int longest = 1;
        int start = 0;
        char[] s = str.toCharArray();
        Integer[][] dp = new Integer[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = 1;
            if(i<length - 1){
                if(s[i] == s[i + 1]){
                    dp[i][i+1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }

        for(int l=3; l<=length; l++){
            for(int i=0; i+l-1 < length;i++){
                int j=l+i-1;//终点
                if(s[i] == s[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }

        return str.substring(start, longest);
    }

    public static void main(String[] args){
        String str = "abdba";
        LongestPalindromeDp longestPalindromeForce = new LongestPalindromeDp();
        System.out.println("动态规划方法——最长回文子串是：" + longestPalindromeForce.longestPalindromeDp(str));
    }
}
