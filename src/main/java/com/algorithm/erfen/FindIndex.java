package com.algorithm.erfen;

/**
 * 有序数组 查找一个数最初出现的位置
 */
public class FindIndex {

    public static int findIndex(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr[0] == target){
            return 0;
        }
        int left = 1;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            //arr[mid] == target
            if(arr[mid] == target){
                if(arr[mid - 1]== target){
                    right = mid - 1;
                    continue;
                }else {
                    return mid;
                }
            }

            //arr[mid] != target
            if(arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,3,3,5,6,7,8,9};
       int index =  findIndex(arr, 3);
       System.out.println(index);
    }
}
