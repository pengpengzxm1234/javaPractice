package com.leetcode;

/**
 * leetcode高频讲解四
 * 有序数组，可能转过
 * 如何快速找到一个数
 * 思路：条件分类（尽可能二分）
 * L到R位置的中点M，只要这三个数不是都相等，就一定可以二分
 * 1、当三个位置的数都相同，L想右移动，直到L的位置的值和另外两个不同，
 * 在根据现在的L 和 R 找M做二分
 * 2、当L移动到了M位置，用M+1位置和R做二分
 *
 */
public class Problem_0033_SearchInRotatedSortedArray {

    public static int search(int[] arr, int num){
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L < R){
            M = (L + R)/2;
            //如果中点M的值是num
            if(arr[M] == num){
                return M;
            }
            //arr[M] != num
            if(arr[M] == arr[L] && arr[M] == arr[R]){//L R M 三个点的值相等
                while (L != M && arr[L] == arr[M]){
                    L++;
                }
                if(L == M){
                    L = M + 1;
                    continue;
                }
            }
            //arr[M] != nul
            //[L] [M] [R]不都相等
            if(arr[L] != arr[M]){
                if(arr[M] > arr[L]){//L ~ M 是有序的
                    if(num > arr[L] && num < arr[M]){
                        R = M - 1;
                    }else {
                        L = M + 1;
                    }
                }else {//M ~ R 是有序的
                    if(num > arr[M] && num < arr[R]){
                        L = M + 1;
                    }else {
                        R = M - 1;
                    }
                }
            }else {//[L] == [M] -> [M] != [R]
                if(arr[M] < arr[R]){//M ~ R 是有序的
                    if(num > arr[M] && num < arr[R]){
                        L = M + 1;
                    }else {
                        R = M - 1;
                    }
                }else {//L ~ M 是有序的
                    if(num  > arr[L] && num < arr[M]){
                        R = M - 1;
                    }else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{4,5,6,7,1,2,3};
        System.out.println(search(arr, 2));
    }
}
