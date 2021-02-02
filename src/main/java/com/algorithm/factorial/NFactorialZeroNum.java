package com.algorithm.factorial;

/**
 * 给定一个非负整数N，返回N！结果的末尾为0的数量
 * 找到有多少个因子5
 * 因为因子2的数目比因子5的数目多，不管有多少个因子5，都会有足够的因子2
 * 与其相乘得到10.
 * 只要找出1~N所有的数中一共有多少个因子5就可以
 */
public class NFactorialZeroNum {

    /**
     * 代价是logi（以5为底），一共有O（N）个数
     * O（NlogN）
     * @param num
     * @return
     */
    public static int zeroNum1(int num){
        if(num < 0){
            return 0;
        }
        int res = 0;
        int cur = 0;
        for(int i = 5; i < num + 1; i=i+5){
            cur = i;
            while (cur % 5 == 0){
                res++;
                cur /= 5;
            }
        }
        return res;
    }

    /**
     * 思路：1~N中有N/5个数，这每个数都能贡献一个5；
     *       1~N中有N/(5^2)个数，这每个数又能贡献一个5
     *       。。。
     * @param num
     * @return
     */
    public static int zeroNum2(int num){
        if(num < 0){
            return 0;
        }
        int res = 0;
        while (num != 0){
            res += num / 5;
            num /= 5;
        }
        return res;
    }
}
