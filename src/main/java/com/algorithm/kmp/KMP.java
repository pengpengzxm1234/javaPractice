package com.algorithm.kmp;

/**
 * kmp算法查找一个字符传是否包含在另一个字符串中，并返回起点位置
 */
public class KMP {

    /**
     * 问题：给定两个字符串str和match，长度分别是N和M，实现一个算法，如果字符串str中含有字串match，
     * 则返回match在str中的开始位置，不含有则返回-1
     */
    public static int getIndexOf(String s, String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int[] next = getNextArray(ms);
        int si = 0;
        int mi = 0;
        while (si < ss.length && mi < ms.length){
            if(ss[si] == ms[mi]){
                si++;
                mi++;
            }else if(next[mi] == -1){
                si++;
            }else {
                mi = next[mi];//前缀子串的结束位置
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    /**
     * 生成match字符串的nextArr数组，这个数组长度与match字符串的长度一致，nextArr[i]的含义是在match[i]之前的字符串match[0..i-1]中，
     * 必须以match[i-1]结尾的后缀子串（不包含match[0]）与必须以match[0]开头的前缀子串(不包含match[i-1])最大匹配长度是多少，这个长度
     * 就是nextArr[i]的值。
     * 用于在匹配的过程中，判断匹配字符的起始判断配置，直接移动到前缀子串的最后的位置向后继续判断
     * @param ms
     * @return
     */
    public static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 1;
        int pos = 2;
        int cn = 0;
        while (pos < ms.length){
            if(ms[pos - 1] == ms[cn]){
                next[pos++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
