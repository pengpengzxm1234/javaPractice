package com.algorithm.erfen;

/**
 * 二分法
 * 找到局部最小的数的位置
 * 数组特点：整体无序（正 负 零），任意两个相邻的数不相等
 * 局部最小：一个数相邻的两个数都比这个数大
 * 思路：1）边界条件0 N-1位置，如果0位置小于1位置的数，成立；如果N-1位置小于N-2位置，成立
 *       2）边界不成立，0位置大于1位置及曲线是下降的，N-1位置大于N-2位置的数，曲线是上扬的，因此 0与N-1之间比存在局部最小
 *       3）取mid 如果mid的两边的数都大于mid的数，mid局部最小，否则，如果mid-1 小于 mid （上扬）继续在 0~mid-1中查找，相反则在mid + 1 到 N-1查找
 */
public class BSAwesome {

    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right){
            mid = left + ((right - left) >> 1);
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
