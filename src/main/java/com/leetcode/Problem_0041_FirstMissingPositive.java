package com.leetcode;

/**
 * leetcode高频讲解五
 * 给定一个无序数组，数有可能是正 负数 和零
 * 返回缺失的最小的正数
 * 如：[1,2,0] 返回 3
 *     [3,4,-1, 1] 返回2
 *     [7,8,9,11,12] 返回1
 *
 * 要求：时间复杂度O(N) 空间复杂度O(1)
 *
 * 荷兰国旗问题的升级基础班第三节 随机快排
 */
public class Problem_0041_FirstMissingPositive {

    /**
     * r最好预期小的缺失的最小值
     * l [0, l-1]满足条件的数组
     * 如数组长度值n，且n是从1到n连续的数，缺失的就是r
     * 不需要的数1）[l] > r l位置上的值大于r的值，打不到最好情况
     *          2) [l] <= l l位置上的值小于等于l，
     *          3) [l] = [[l] - 1] l的值是v e而 v-1位置上的值也是v，因此也打不到最好预期
     *          r前面位置的值和l位置的值交换，r来到前面位置（r原来的位置相当于垃圾回收站）
     *  满足条件 [l] = l + 1, 时，l向右移动
     * @param arr
     * @return
     */
    public static int firstMissingPositive(int[] arr){
        int l = 0;
        int r = arr.length;//预期在arr.length位置是最优的
        while (l < r){
            if(arr[l] == l + 1){
                l++;
            }else if(arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]){
                swap(arr, l, --r);//不满足条件，r前一个位置和l交换且r向左移动
            }else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
