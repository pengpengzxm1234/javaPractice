package com.leetcode;

/**
 * leetcode高频讲解一
 * 给定两个不等长（或等长）的有序数组，求两个数组整体的中位数
 * 如：nums1 =【1,2】， nums2 = 【3】 median= 2.0
 *    nums1 = 【1，2】，nums2 = 【3,4】 median = （2 + 3）/ 2 = 2.5
 *
 * 提取了两个函数，f函数和g函数，用来作为以后操作排序数组取数的基础方法，高效，最优
 * 以后如果遇到需要在有序数组中取数的，可以看情况考虑使用这两个基础方法
 */
public class Problem_0004_MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int size = nums1.length + nums2.length;
        boolean even = (size & 1) == 0;//判断是否为偶数
        if(nums1.length != 0 && nums2.length != 0){
            if(even){
                return (double)(findKthNum(nums1, nums2, size / 2) + findKthNum(nums1, nums2, size / 2 + 1))/2D;
            }else {
                return (double)findKthNum(nums1, nums2, size / 2 + 1);
            }
        }else if(nums1.length != 0){
            if(even){
                return (double)(nums1[(size - 1)/2] + nums1[size/2])/2;
            }else {
                return (double)nums1[size / 2];
            }
        }else if(nums2.length != 0){
            if(even){
                return (double)(nums2[(size - 1)/2] + nums2[size/2])/2;
            }else {
                return (double)nums2[size / 2];
            }
        }else {
            return 0;
        }

    }


    /**
     * f函数
     * @param arr1 有序数组1
     * @param arr2 有序数组2
     * @param kth 整体排序后第k小的数
     * @return
     *
     * 考察函数类型（g函数）： 两个有序数组，整体排序后取最小的第k个数
     * 如果arr1有10个数，arr2有17个数，取第k小个数，
     * 1）1<=k<=10,如取7个，arr1取前7个，arr2取前7个，利用f函数，取上中位数
     * 2）10<k<=17,如取15，手动判断5‘（1’--4‘，16’-17‘淘汰），如果5是，则是，
     *    不是则排除5’，然后arr1取全部，arr2取6-15，利用f函数，取上中位数（取左不取右）
     * 3）17<k<=27，取23，手动验证6和13‘(1 大于 17’取6, 1'大于10，取13')，如果其中一个是，则是；
     *    不是，则排除6和13’，然后取a1的7-10和a2的14‘-17’取上中位数，得解
     */
    public static int findKthNum(int[] arr1, int[] arr2, int kth){
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr2 : arr1;
        int l = longs.length;
        int s = shorts.length;
        if(kth <= s){
            return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
        }
        if(kth > l){
            if(shorts[kth - l - 1] >= longs[l -1]){
                return shorts[kth - l - 1];
            }
            if(longs[kth - s] >= shorts[s - 1]){
                return longs[kth - s];
            }
            return getUpMedian(shorts, kth - l , s - 1, longs, kth - s, l - 1);
        }
        //第二种情况，手动排除
        if(longs[kth - s - 1] >= shorts[s - 1]){
            return longs[kth - s - 1];
        }
        return getUpMedian(shorts, 0, s-1, longs, kth - s, kth - 1);
    }

    /**
     * f函数
     * 求两个数组长度相等时的上中位数
     * @param a1 数组
     * @param s1 数组a1 开始位置
     * @param e1 a1的结束位置
     * @param a2
     * @param s2 a2的开始位置
     * @param e2 a2的结束位置
     * @return
     *
     * 实现底层函数（f函数）：数组arr1和arr2是有序且长度相等的，返回两个数组整体排序后的上中位数 如：【1,2,3,4】返回2
     * 1、arr1 和 arr2都是偶数个
     *  比较两个数组的上中位数的值：O(log(短数组长度))
     *   1）如果两个数相同，则该值就是整体的上中位数；
     *   2）如果两个数不相等，如果是arr1 > arr2，会有多种情况，需要考虑整体的arr1和arr2下部的几个数的比较。
     *      这块和用arr1上中位数部分组成的数组和arr2下中位数部分组成的数组做递归计算，求他们整体的上中位数，
     *      这个上中位数就是arr1和arr2的上中位数。(如果是arr2 > arr1 情况相反，过程相同，记用arr2的上中位数组
     *      比较arr1的下中位数组)
     * 2、arr1 和 arr2都是奇数个：
     *    1）如果两个上中位数相同，则是整体的上中位数
     *    2）如果两个数不相等，手动淘汰一个，然后同偶数做递归
     *
     * 时间复杂度O(logN)
     */
    public static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2){
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1){
            mid1 = (s1 + e1) / 2;
            mid2 =  (s2 + e2) / 2;
            if(a1[s1] == a2[s2]){
                return a1[mid1];
            }
            if(((e1 - s1 + 1) & 1) == 1){//奇数长度
                if(a1[mid1] > a2[mid2]){
                    if(a2[mid2] >= a1[mid1 - 1]){//判断奇数较小的上中位数是否是整个数组的中位数,如不是，则剩余的转为偶数求中位数
                        return a2[mid2];
                    }
                    e1 = mid1 - 1;
                    s2 = mid2 + 1;
                }else {//a1[mid1] < a2[mid2]
                    if(a1[mid1] >= a2[mid2 - 1]){
                        return a1[mid1];
                    }
                    e2 = mid2 - 1;
                    s1 = mid1 + 1;
                }
            }else {
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
}
