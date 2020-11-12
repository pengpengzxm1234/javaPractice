package com.algorithm.heap;

/**
 * 堆排序
 * 1，先让整个数组都变成大根堆结构，建立堆的过程:
 * 1)从上到下的方法，时间复杂度为O(N*logN)
 * 2)从下到上的方法，时间复杂度为O(N)
 * 2，把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，一直周而复始，时间复杂度为O(N*logN)
 * 3，堆的大小减小成0之后，排序完成
 */
public class MyHeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //O(N)
        for(int i = arr.length - 1; i>=0; i--){
            heapify(arr, i, arr.length);
        }
        //O(N * log)
       int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }


    //输出后进行大根堆重新调整满足大根堆的条件
    public static void heapify(int[] arr, int index, int heapSize){
        //找到左子节点位置
        int left = 2 * index + 1;
        while (left < heapSize){
           int largest = left + 1 < heapSize && arr[left + 1] > arr[left]? left + 1 : left;
           largest = arr[largest] > arr[index] ? largest : index;
           if(largest == index){
               break;
           }
           swap(arr,largest, index);
           index = largest;
           left = index * 2 + 1;
        }
    }

    public void heapInsert(int[] arr, int index){
        while (arr[index] > arr[((index - 1)/2)]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //for test
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for(int i=0; i< arr.length; i++){
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args)throws Exception{
        int[] arr = generateRandomArray(10, 10);
        printArray(arr);
        heapSort(arr);
        printArray(arr);

    }

}
