package com.algorithm.erfen;

/**
 * 二分法使用
 * 二分查找
 * 查找一个数知否再有序数组中出现
 * O(logN)
 */
public class BSExist {
    public static boolean exist(int[] sortArr, int num){
        if(sortArr == null || sortArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortArr.length - 1;
        int mid = 0;
        while (L < R){//L R 至少两个数
            mid = L + ((R - L) >> 1); //mid = （R +L）/ 2;  不安全，可能溢出
            if(sortArr[mid] == num){
                return true;
            }else if(sortArr[mid] > num){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        //退出循环的时候，可能有一个数没有验证
        return sortArr[L] == num;
    }
}
