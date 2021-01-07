package com.leetcode;

/**
 * leetcode高频讲解二
 * 难题，
 * 给两个字符串s和p，s只包含小写字母a-z，p包含小写字母a-z还有别的符号（.或者*，.可以变成任意字符，*要和前面的字符配合使用）
 * 验证：p是否能够正则匹配出s
 * 如 s： abcd
 *    p： .*  可以让p变成....然后再变成abcd（*配合.使用，变成....,点可以变成任意字符，则....变成abcd）
 *  即 在一定规则下p能否变成s
 */
public class Problem_0010_RegularExpressionMatching {


    public static boolean isMatch1(String s, String p){
        if(s == null || p == null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return isValid(str, pattern) && precess(str, pattern, 0, 0);
    }


    public static boolean isValid(char[] str, char[] pattern){
        for(char cha :str){
            if(cha == '.' || cha == '*'){//str中不能含有.和* 可以处理空串
                return  false;
            }
        }
        for(int i = 0; i< pattern.length; i++){//*不能单独使用 可以处理空串
            if(pattern[i] == '*' && (i == 0 || pattern[i-1] == '*')){
                return false;
            }
        }
        return false;
    }

    //str[si ...]能否被pattern[pi ...] 变出来
    //潜台词： pi位置的字符 pattern[pi]不是*
    public static boolean precess(char[] str, char[] pattern, int si, int pi){
        if(si == str.length){//str[si...]代表“”（空字符串）si越界了
            //pattern[pi] 也是""
            if(pi == pattern.length){
                return true;
            }

            if(pi + 1 < pattern.length && pattern[pi + 1] == '*'){
                return precess(str, pattern, si, pi + 2);
            }

            return false;
        }
        //si没有越界
        if(pi == pattern.length){//pattern[pi..]是空串 pi越界了
            return si == str.length;
        }

        //si pi都没越界
        //si pi都没有终止
        if(pi + 1 >= pattern.length || pattern[pi+1] != '*'){//pi+1位置不是*（后面没有字符或者字符不是*）
            //pi独立面对si,是否可以匹配
            return ((str[si] == pattern[pi]) || (pattern[pi] == '.'))
                    && precess(str, pattern, si+1, pi+1);
        }

        //si pi都没越界 pi + 1是*
        if(pattern[pi] != '.' && str[si] != pattern[pi]){
            return precess(str, pattern ,si, pi + 2);
        }

        //?* 0份
        if(precess(str, pattern, si, pi + 2)){//pi和pi+1要变成0，pi+2能和si匹配
            return true;
        }

        //判断有多少si和pattern[pi]相等
        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')){
            if(precess(str, pattern, si+1, pi+2)){
                return true;
            }
            si++;
        }

        return false;
    }


    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p){
        if(s == null || p == null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int[][] dp = new int[str.length + 1][p.length() + 1];
        for(int si = 0; si<= str.length; si++){//chushihua shuzu
            for(int pi = 0; pi<= pattern.length; pi++){
                dp[si][pi] = -1;
            }
        }
        //dp[si][pi] = -1 还没有操作
        //dp[si][pi] = 0 返回值是false
        //dp[si][pi] = 1 返回值是true

        return isValid(str, pattern) && precess2(str, pattern, 0, 0, dp);
    }

    //str[si ...]能否被pattern[pi ...] 变出来
    //潜台词： pi位置的字符 pattern[pi]不是*
    public static boolean precess2(char[] str, char[] pattern, int si, int pi, int[][] dp){
        if(dp[si][pi] != -1){
            return dp[si][pi] == 1;
        }
        //si pi 是第一次算
        if(si == str.length){//str[si...]代表“”（空字符串）si越界了
            //pattern[pi] 也是""
            if(pi == pattern.length){
                dp[si][pi] = 1;
                return true;
            }

            if(pi + 1 < pattern.length && pattern[pi + 1] == '*'){
                boolean ans = precess2(str, pattern, si, pi + 2, dp);
                dp[si][pi] = ans ? 1 : 0;
                return ans;
            }
            dp[si][pi] = 0;
            return false;
        }
        //si没有越界
        if(pi == pattern.length){//pattern[pi..]是空串 pi越界了

            boolean ans = si == str.length;
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        //si pi都没越界
        //si pi都没有终止
        if(pi + 1 >= pattern.length || pattern[pi+1] != '*'){//pi+1位置不是*（后面没有字符或者字符不是*）
            //pi独立面对si,是否可以匹配
            boolean ans = ((str[si] == pattern[pi]) || (pattern[pi] == '.'))
                    && precess2(str, pattern, si+1, pi+1, dp);
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        //si pi都没越界 pi + 1是*
        if(pattern[pi] != '.' && str[si] != pattern[pi]){
            boolean ans =  precess2(str, pattern ,si, pi + 2, dp);
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        //?* 0份
        if(precess2(str, pattern, si, pi + 2, dp)){//pi和pi+1要变成0，pi+2能和si匹配
            dp[si][pi] = 1;
            return true;
        }

        //判断有多少si和pattern[pi]相等
        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')){
            if(precess2(str, pattern, si+1, pi+2, dp)){
                dp[si][pi] = 1;
                return true;
            }
            si++;
        }
        dp[si][pi] = 0;
        return false;
    }
}
