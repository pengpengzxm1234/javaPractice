package com.leetcode;

/**
 * leetcode高频讲解二
 * 翻转整型的数 如 123 321，-123 -321, 120 21
 */
public class Problem_0007_ReverseInteger {


    /**
     *
     * @param x 整数
     * @return
     * 无论是什么数，都按照负数来处理
     * 因为负数可以表达的绝对值域是大于整数可以表达的绝对值域的，正数全部都可以转成负数
     * 注：正数用负数来处理是一个常用做法,为了防止正数的溢出
     */
    public static int reverse(int x){
        //用位运算判断整数的正负（等于1是负数，反之是正数），x >>> 31代表符号位，即最低位
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        //m和n用来检测溢出
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0){
            //1、res * 10 后，必定会比m小 2、res * 10后==m，加上余数溢出（x取模10的值别o小）
            if(res < m || (res == m && x % 10 < o)){//判断溢出
                return 0;
            }
            res = res * 10 + x % 10;//每次将x的最后一位赋值给res
            x /= 10;//x向前移动一位（去掉末位）
        }
        return neg ? res : Math.abs(res);
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
    }
}
