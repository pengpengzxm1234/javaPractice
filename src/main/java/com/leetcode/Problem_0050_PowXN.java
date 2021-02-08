package com.leetcode;

/**
 * leetcode高频讲解七
 * 算一个double数的N次方
 * 快速幂
 */
public class Problem_0050_PowXN {
    //提升速度
    //思路：。例如a^75 75的二进制数=1  0   0  1  0  1  1
    //                            64  32 16  8  4  2  1(二进制数对应乘方)
    //  a^75 = a^64 * a^8 * a^2 * a(二进制数上是1的就成进去，因为a的0次方是1)
    //复杂度logN
    public static double myPow(double x, int n){
        if(n == 0){
            return 1D;
        }
        if(n == Integer.MIN_VALUE){//溢出（或者特别小）返回0，除了1的情况
            return (x == 1D || x == -1D) ? 1D : 0;
        }
        int pow = Math.abs(n);
        double t = x;
        double ans = 1D;
        while (pow != 0){
            if((pow & 1) != 0){//  a^75 = a^64 * a^8 * a^2 * a
                ans *= t;
            }
            pow >>= 1;//右移一位
            t = t * t;//(二进制数对应乘方)
        }
        return n < 0 ? (1D / ans) : ans;
    }
}
