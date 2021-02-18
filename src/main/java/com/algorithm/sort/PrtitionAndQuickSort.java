package com.algorithm.sort;

/**
 * 快速排序
 */
public class PrtitionAndQuickSort {

    /**
     * 荷兰国旗问题 区域划分（小于区|等于区|大于区）
     * 返回的是等于区的起止位置的数组
     * （快速排序的前置算法）
     * 以arr[R]作为划分值
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R){
        if(L > R){
            return new int[] {-1, -1};
        }
        if(L == R){
            return new int[] {L, R};
        }
        int less = L - 1;// < 右边界
        int more = R;//大于区 左边界
        int index = L;
        while (index < more){//当前位置不能和大于区重合
            if(arr[index] == arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                swap(arr, index++, ++less);
            }else {
                swap(arr, index , --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 快排2.0
     * @param arr
     * O(N^2)
     */
    public static void quickSort2(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }


    //随机快排
    //随机选择一个数，放到数组最右边
    //时间复杂度：O(N*logN）
    //额外空间复杂度：O(logN)
    public static void quickSort3(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);//随机取一个数和R交换
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[0] + 1, R);
    }
}
