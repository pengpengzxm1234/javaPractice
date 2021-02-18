package com.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 选择排序
 * 依次从数组未排好序的数组中，选择出最小的数，并和数组中前面的位置依次交换
 * 直到最后
 * O(N^2)(所有i的遍历是一个等差数列)
 * 如，{4,2,6,3,10, 9}
 * 1）0~n找到最小值2的位置，与0位置的值交换 {2,4,6,3,10, 9}
 * 2）1~n找到找到最小的值3的位置，与1位置的值交换{2,3,6,4,10, 9}
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i = 0; i<arr.length ;i++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {3,2,4,6,10, 9};
        selectionSort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
