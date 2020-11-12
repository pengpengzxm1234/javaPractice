package com.designpatterns.strategy;

/**
 * 策略模式中的client，调用 comparator接口的方法调用不同的比较策略
 * @param <T>
 */
public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator){
        for(int i=0; i<arr.length;i++){
            int minPos = i;

            for(int k=i+1; k< arr.length; k++){

                minPos = comparator.compare(arr[k], arr[minPos]) == -1  ? k : minPos;
            }

            swap(arr, i, minPos);
        }
    }

    void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
