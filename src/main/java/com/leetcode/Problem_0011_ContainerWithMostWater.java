package com.leetcode;

/**
 * leetcode高频讲解二
 * 有N多个杆的高度，选取两个杆，两个杆之间装满水，求可装的最大的水量
 * 思路：
 * 看两头，哪一处小（小的是瓶颈，没法再装更多的水），就以小的那一处来结算
 * 左侧和右侧，谁小结算谁
 * 关注总的最大水量有没有提升，不去关注每个位置是否是最优解(不严格关心每个杆的最优解)
 *
 */
public class Problem_0011_ContainerWithMostWater {

    public static int maxArea(int[] h){
        int max = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r){
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if(h[l] > h[r]){//谁小结算谁（谁小谁移动一位）
                r--;
            }else {
                l++;
            }
        }
        return max;
    }
}
