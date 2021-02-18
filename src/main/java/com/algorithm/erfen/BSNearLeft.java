package com.algorithm.erfen;

/**
 * 二分法
 * 找到数组中满足大于等于n的值的最左的位置
 */
public class BSNearLeft {
    public static int nearestIndex(int[] arr, int value){
        int L = 0;
        int R = arr.length - 1;
        int index = 0;
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] >= value){
                index = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }
}
