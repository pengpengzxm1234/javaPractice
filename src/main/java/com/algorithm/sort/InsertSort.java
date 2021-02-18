package com.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 插入排序
 * 一个未排序的数组
 * 1) 0位置上有序
 * 2） 1位置上与0位置比较，小则交换（直到0位置）。。（0~1范围有序）
 * 3）n位置上的数依次向前比较，小则交换
 * O(N^2)
 */
public class InsertSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for (int i = 1; i<arr.length; i++){// 0 ~ i 做到有序
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args){
        int[] arr = {4, 2, 6, 3, 10, 9};
        insertionSort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
