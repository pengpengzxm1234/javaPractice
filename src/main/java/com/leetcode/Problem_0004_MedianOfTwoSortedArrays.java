package com.leetcode;

/**
 * 给定两个有序数组求两个数组的中位数
 *
 *
 */
public class Problem_0004_MedianOfTwoSortedArrays {

    public static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2){
        int mid1 = 0;
        int mid2 = 0;
        while (s1 < e1){
            mid1 = (e1 + s1 )/2;
            mid2 = (e2 + s2)/2;
            if(a1[mid1] == a2[mid2]){
                return a1[mid1];
            }
            if(((e1 - s1 + 1) & 1) == 1){//奇数长度
                if(a1[mid1] > a2[mid2]){
                    if(a2[mid2] >= a1[mid1 - 1]){//判断奇数较小的上中位数是否是整个数组的中位数,如不是，则剩余的转为偶数求中位数
                        return a2[mid2];
                    }
                    e1 = mid1 - 1;
                    s2 = mid2 + 1;
                }else {
                    if(a1[mid1] >= a2[mid2 - 1]){
                        return a1[mid1];
                    }
                    e2 = mid2 - 1;
                    s1 = mid1 + 1;
                }
            }else {//偶数长度
                if(a1[mid1] > a2[mid2]){
                    e1 = mid1;
                    s2 = mid2 + 1;
                }else {
                    e2 = mid2;
                    s1 = mid1 + 1;
                }
            }

        }
        return Math.min(a1[s1], a2[s2]);

    }


    public static void main(String[] args){
        System.out.println((4 & 1));
    }

}


