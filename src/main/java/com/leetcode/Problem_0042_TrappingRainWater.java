package com.leetcode;

/**
 * leetcode高频讲解五
 * 直方图数组
 * 问有多少格的水
 */
public class Problem_0042_TrappingRainWater {

    //思考i位置上能留下几个水
    //如果i位置左边有一个10高度，有位置有一个20高度，就一定可以让水的高度来到10的位置
    //i位置的水量=不包括i位置的左侧的最大值 与 不包括i位置右侧的最大值 中的较小的值 减去 i位置本身的高度  再和0取max
    //left数组，保留0-（i-1）左侧最大值的数组
    //right数组，i到n-1位置右侧最大值
    //0位置和n-1位置不管是什么值。一定无水
    public static int trap(int[] arr) {
        if(arr == null || arr.length < 3){
            return 0;
        }
        int N = arr.length;
        int L = 1;//左指针
        int R = N - 2;//右指针
        int leftMax = arr[0];//左侧最大值初始值
        int rightMax = arr[N - 1];//右侧最大值初始值
        int warter = 0;
        while (L <= R){
            if(leftMax <= rightMax){
                warter += Math.max(0, leftMax - arr[L]);
                leftMax = Math.max(leftMax, arr[L++]);//更新左侧最大值,L向右移动
            }else {
                warter += Math.max(0, rightMax - arr[R]);
                rightMax = Math.max(rightMax, arr[R--]);//更新右侧最大值，R向左移动
            }
        }
        return warter;
    }
}
