package com.leetcode;

/**
 *  leetcode高频讲解五
 *  本题和第10题类似
 *  给定一个字符串s，要么是空，要么只包含小写字母
 *  还有一个字符串p，要么是空，要么是小写字母有？和*
 *  ？：可以替换成任何别的一个小写字母（单一，不为空），*可以代表任意字符串（可以是空串）
 *  问：p通过变化是否可以变成s
 *  基础：尝试模型
 */
public class Problem_0044_WildcardMatching {

    public static boolean isMatch1(String str, String pattern){
        if(str == null && pattern == null ){
            return true;
        }
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        return process1(s, p, 0, 0);
    }

    /**
     * 尝试(递归)
     * 定义一个f函数，s p si pi 返回 boolean
     * s[si..]和p[pi..]能够匹配所有
     * 暴力方法 会超时
     */
    public static boolean process1(char[] s, char[] p, int si, int pi){
        if(si == s.length){//s结束了
            if(pi == p.length){//p 也结束了
                return true;
            }else {//p还没结束，看是否能配出空字符串，看是否剩下的都是*
                //pi位置一定是*，并且 p[pi + 1]也能匹配出空
                return p[pi] == '*' && process1(s, p, si, pi+1);
            }
        }

        if(pi == p.length){//p结束了，只有s也结束，才能匹配
            return si == s.length;
        }
        //si未结束，pi未结束
        //s[si]小写字母
        //p[pi]小写字母 ？ *
        if(p[pi] != '?'&& p[pi] != '*'){//pi位置不是?字符和*
            //p[pi]是小写字母，s[si] 和 p[pi] 字符需要匹配 && s 和 p后续也要匹配
            return s[si] == p[pi] && process1(s, p, si+1, pi+1);
        }
        //si pi 未结束 pi是 ? 或 *
        if(p[pi] == '?'){//匹配一切字符
            return process1(s, p, si + 1, pi +1);
        }
        //pi是* 每一种字符前缀都要尝试
        for(int len =0; len <= s.length - si; len++){
            if(process1(s, p, si + len, pi+1)){//pi匹配了si + len 长度，看剩下的是否能有pi+1匹配出来
                return true;
            }
        }
        return false;
    }

    /**
     * 优化
     * 动态规划(把尝试的行为变为依次变化的表结构)
     * 递归的尝试策略就是动态规划的转移策略
     */
    public static boolean isMatch2(String str, String pattern){
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int N  = s.length;
        int M = p.length;
        //入参一旦确定，返回值就确定
        // 枚举所有返回值
        boolean[][] dp = new boolean[N+1][M+1];
        //dp[si][pi] 代表 process1(s, p, si, pi)的返回值
        dp[N][M] = true;
        //dp[N][...]
        for(int pi = M - 1; pi>=0; pi--){
            dp[N][pi] = p[pi] == '*' && dp[N][pi+1];
        }
        //dp[...][M] 只有dp[N][M]是true 其余都是false 不用填，默认false 不需要改，天然是对的

        //具体的si pi
        //任何普遍位置的值，都会依赖 si+1 pi+1位置的值还有si右边格子及其往下所有列的格子
        //因此，格子从右向左填（横向），再从下往上填（纵向），最终填写到dp[0][0]
        for(int si = N - 1; si >= 0; si--){
            for(int pi = M - 1;pi >= 0; pi--){
                if(p[pi] != '?' && p[pi] != '*'){
                    dp[si][pi] = s[si] == p[pi] && dp[si + 1][ pi + 1];
                    continue;
                }

                if(p[pi] == '?'){
                    dp[si][pi] = dp[si+1][pi+1];
                    continue;
                }
                for(int len = 0; len <= s.length - si; len++){
                    if(dp[si + len][pi + 1]){
                        dp[si][pi] = true;
                        break;
                    }
                }
            }
        }

        return dp[0][0];
    }

    /**
     * 斜率优化
     * 观察临近的格子能否替代枚举行为
     */
    public static boolean isMatch2_1(String str, String pattern){
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int N  = s.length;
        int M = p.length;
        //入参一旦确定，返回值就确定
        // 枚举所有返回值
        boolean[][] dp = new boolean[N+1][M+1];
        //dp[si][pi] 代表 process1(s, p, si, pi)的返回值
        dp[N][M] = true;
        //dp[N][...]
        for(int pi = M - 1; pi>=0; pi--){
            dp[N][pi] = p[pi] == '*' && dp[N][pi+1];
        }
        //dp[...][M] 只有dp[N][M]是true 其余都是false 不用填，默认false 不需要改，天然是对的

        //具体的si pi
        //任何普遍位置的值，都会依赖 si+1 pi+1位置的值还有si右边格子及其往下所有列的格子
        //因此，格子从右向左填（横向），再从下往上填（纵向），最终填写到dp[0][0]
        for(int si = N - 1; si >= 0; si--){
            for(int pi = M - 1;pi >= 0; pi--){
                if(p[pi] != '?' && p[pi] != '*'){
                    dp[si][pi] = s[si] == p[pi] && dp[si + 1][ pi + 1];
                    continue;
                }
                if(p[pi] == '?'){
                    dp[si][pi] = dp[si+1][pi+1];
                    continue;
                }
                dp[si][pi] = dp[si][pi + 1] || dp[si +1][pi];
            }
        }
        return dp[0][0];
    }
}
