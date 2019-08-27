package com.algorithm.longestPalindrome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manacher算法
 * 这是一个专门用作处理最长回文子串的方法，思想很巧妙，比较难以理解，
 * 这里直接借用了别人的讲解方法。其实主要思想是，把给定的字符串的每
 * 一个字母当做中心，向两边扩展，这样来找最长的子回文串，这个叫中心扩展法，
 * 但是这个方法还要考虑到处理abba这种偶数个字符的回文串。
 * Manacher法将所有的字符串全部变成奇数个字符。
 *
 *
 * Manacher算法的时间复杂度分析和Z算法类似，因为算法只有遇到还没有匹配的位
 * 置时才进行匹配，已经匹配过的位置不再进行匹配，所以对于T字符串中的每一个位
 * 置，只进行一次匹配，所以Manacher算法的总体时间复杂度为O(n)，其中n为T字
 * 符串的长度，由于T的长度事实上是S的两倍，所以时间复杂度依然是线性的
 */

public class LongestPalindromeManacher {
    private static final Logger LOGGER = LoggerFactory.getLogger(LongestPalindromeManacher.class);


    public static void main(String[] args){
        String str = "abbadabba";
        LongestPalindromeManacher manacher = new LongestPalindromeManacher();
        LOGGER.info(manacher.manacher(str));
    }

    public String manacher(String str){
        String manaStr = "#";
        char[] strArrys = str.toCharArray();
        for(char strChar : strArrys){
            manaStr += strChar;
            manaStr += "#";
        }
        LOGGER.info("manaStr:{}",manaStr);
        char[] manaChar = manaStr.toCharArray();
        Integer[] rd = new Integer[manaStr.length()];
        int pos = 0, mx = 0;
        int start = 0, maxLen = 0;
        for(int i=1; i < manaStr.length(); i++){
            rd[i] = i < mx ? min(rd[2 * pos - i], mx - i) : 1;

            while (i+rd[i] < manaStr.length() && i - rd[i] > 0 && manaChar[i + rd[i]] == manaChar[i - rd[i]]){
                rd[i]++;
            }
            if(i + rd[i] > mx){
                pos = i;
                mx = i +rd[i];
            }
            if(rd[i] - 1 > maxLen){
                start = (i - rd[i]) / 2;
                maxLen = rd[i] -1;
            }
            LOGGER.info("i:{}, rd[{}]={}, mx:{}, maxLen:{}, pos:{}", i, i, rd[i], mx, maxLen, pos);
        }
        LOGGER.info("start:" + start + ",maxlen:" + maxLen);
        return str.substring(start, maxLen + 1);
    }

    private Integer min(Integer value1, Integer value2){
        if(value1 > value2){
            return value2;
        }else if(value1 < value2){
            return value1;
        }else {
            return value1;
        }
    }
}
