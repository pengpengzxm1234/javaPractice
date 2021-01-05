package com.leetcode;

/**
 *  leetcode高频讲解二
 *  字符转整数
 *  要考虑边界条件
 *  如 123lkj123 转为123 （取前面没有字符的，字符后面的数字无效）
 */
public class Problem_0008_StringToInteger {

    public static int myAtoI(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        s = removeHeadZero(s);
        char[] str = s.toCharArray();
        if(!isValid(str)){
            return 0;
        }
        //str是符合日常书写的，正经的数字字符串
        boolean posi = str[0] == '-' ? false : true;//判断是否是整数（非负）
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for(int i = (str[0] == '-' || str[1] == '+') ? 1 : 0; i < str.length; i++){
            cur = '0' - str[i];//用0的ASCII减i位置的ascii码，得到该值的负数
            //res 小于系统最小值/10,res * 10肯定溢出 || res 加上一个小于最小值模10的值，也一定溢出
            if((res < minq) || (res == minq && cur < minr)){
                return posi ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + cur;
        }
        if(posi && res == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return posi ? -res : res;
    }

    /**
     * 去掉字符串头部的0 并截取字符出现前的那串数字(123ksk -> 123)
     * 注：负的系统最小还是自己
     * @param str
     * @return
     */
    public static String removeHeadZero(String str){
        boolean r = (str.startsWith("+") || str.startsWith("-"));
        int s = r ? 1 :0;//如果有符号，从1位置开始遍历字符串
        for(;s < str.length();s++){
            if(str.charAt(s) != '0'){//遇到第一个不为0的数，跳出
                break;
            }
        }
        // s 到了第一个不是'0'字符的位置
        int e = -1;
        for(int i = str.length();i>=(r ? 1 : 0);i--){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                e = i;
            }
        }
        // e 到了最左的 不是数字字符的位置
        return (r ? String.valueOf(str.charAt(0)) :"") + (str.substring(s, e == -1 ? str.length() : e));//截取字符串前的数字在前边加上符号位，如果存在符号
    }

    /**
     * 验证字符串是否是有效书写
     * @param chars
     * @return
     */
    public static boolean isValid(char[] chars){
        //开头不是正负号，且也不是数字字符
        if(chars[0] != '-' && chars[0] != '+' && (chars[0] < '0' || chars[0] > '9')){
            return false;
        }
        //字符串长度只有1且还是'+'或者'-'符号
        if((chars[0] == '-' || chars[0] == '+') && chars.length == 1){
            return false;
        }
        //从1位置开始，只要有一个不是数字字符，返回false
        for(int i = 1;i<chars.length;i++){
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
}
