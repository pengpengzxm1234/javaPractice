package com.algorithm.factorial;

/**
 * 给定一个非负整数N，如果用二进制数表达N！的结果，
 * 返回最低位的1在哪个位置上，认为最右的位置为0
 */
public class RightOne {

    //二进制数右移一位相当于该数值除以2

    /**
     * 最低位的1在哪个位置上，完全取决于1~N的数中因子2有多少个，
     *  因为只要出现一个因子2，最低位的1就会向左移动一位
     * @param num
     * @return
     */
    public static int rightOne(int num){
        if(num < 1 ){
            return -1;
        }
        int res = 0;
        while (num != 0){
            num >>>=1;
            res +=1;
        }
        return res;
    }

    /**
     * 解法2：
     * 如果把N！结果因子中因子2的总个数记为Z，把N的二进制数表达式中1的个数记为m，
     * 还存在一个关系 Z = N - m
     */
    public static int rightOne2(int num){
        if(num < 1){
            return -1;
        }
        int ones = 0;
        int tmp = num;
        while (tmp != 0){
            ones += (tmp & 1) != 0 ? 1: 0;//1的个数
            tmp >>>= 1;
        }
        return num - ones;
    }

    public static void main(String[] args){
        System.out.println((9 & 1));
    }
}
