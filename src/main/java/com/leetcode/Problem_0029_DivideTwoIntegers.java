package com.leetcode;

/**
 * leetcode高频讲解四
 * 实现两个数的加减乘除，但不能使用乘除符号
 *
 * 不用任何算数运算符！！！
 * 1、两个数相加的进位信息算法 （a&b）<< 1  a与b 向左移动一位
 * 2、两个数相加的无进位信息 a异或b a^b
 * 两个数相加=两个数相加的无进位信息+两个数相加的进位信息
 * ##当某一个时刻，进位信息全部消失，无进位信息就是答案
 * 算数运算的底层是位运算实现的
 *
 *
 */
public class Problem_0029_DivideTwoIntegers {

    public static int add(int a, int b){
        int sum = a;
        while (b != 0){//进位信息消失，完成计算
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //相反数取法：按位取反再加一
    public static int negNum(int n){
        return add(~n , 1);
    }

    //减法 a加上b的相反数
    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    //乘
    //a向左移动 b向右移动，判断b末位的值，如果是1，就加上当前a的值，直到b移动到头
    public static int mutil(int a, int b){
        int res = 0;
        while ( b != 0){
            if((b & 1) != 0){//b中还存在1
                res = add(res , a);
            }
            a <<=1;
            b >>>=1;
        }
        return res;
    }


    /**
     * /除法 （都转成正数算）
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public static int divide(int dividend, int divisor){
        //分情况讨论
        //除数是系统最小（系统最小无法转成正数）
        if(divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        //除数不是系统最小
        //系统最小的值减1做除法，在把剩余没有算的补偿进去
        if(dividend == Integer.MIN_VALUE){
            if(divisor == negNum(1)){//除数是-1
                return Integer.MAX_VALUE;
            }
            int res = div(add(dividend, 1), divisor);
            return add(res, div(minus(dividend, mutil(res, divisor)), divisor));
        }
        //被除数和除数都不是系统最小
        return div(dividend, divisor);
    }

    //b向左移动几位最接近a但不超过a，用a减去这个移动后的值
    public static int div(int a, int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > negNum(1); i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    //判断是否负数
    public static boolean isNeg(int n){
        return n < 0;
    }

}
