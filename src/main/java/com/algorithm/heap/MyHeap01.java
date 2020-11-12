package com.algorithm.heap;


import com.alibaba.fastjson.JSONArray;


/**
 * 堆，用数组实现的一颗完全二叉树
 * 1、大根堆 任一个节点为根节点时，都是根节点大于子节点
 * 2、小根堆 任一个节点为根节点时，都是根节点小于子节点
 * 下面实现一个大根堆和一个小根堆
 * 子节点找父节点 （index- 1）/2
 * index 为父亲节点
 * 左孩子： 2 * index + 1
 * 右孩子： 2 * index + 2
 *
 * 堆pop每次取最大的数
 */
public class MyHeap01 {

    /**
     * 大根堆
     */
    public static class MaxRootHeap{
        private int[] heap;
        private int heapSize;
        private int limit;

        public MaxRootHeap(int limit){
            heapSize = 0;
            this.limit = limit;
            heap = new int[limit];
        }

         boolean isEmpty(){
            return heapSize == 0;
        }

        boolean isFull(){
            return heapSize == limit;
        }

        Integer Size(){
            return heapSize;
        }

        void push(int value){
            if(heapSize == limit){
                throw  new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heapSize++);
        }

        // 用户此时，让你返回最大值，并且在大根堆中，把最大值删掉
        // 剩下的数，依然保持大根堆组织
        int pop(){
            int value = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return value;
        }

        /**
         * 和父亲节点比较，如果子节点的值大于父亲节点，子节点和父亲节点交换，
         * @param index
         */
        private void heapInsert(int index){
            while (heap[index] > heap[(index - 1)/2]){
                swap(heap, index, (index - 1)/2);
                index = (index - 1)/2;
            }
        }

        /**
         * 对heap重新组合使其满足大根堆的特性
         * // 从index位置，往下看，不断的下沉，
         // 停：我的孩子都不再比我大；已经没孩子了
         */
        private void heapify(int[] arr, int index, int heapSize){
            int left = 2 * index + 1;
            while (left < heapSize){
                // 左右两个孩子中，谁大，谁把自己的下标给largest
                // 右  ->  1) 有右孩子   && 2）右孩子的值比左孩子大才行
                // 否则，左
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                //大的孩子节点和父亲节点比较，取大的下标赋值给largest
                largest = arr[largest] > arr[index] ? largest : index;
                if(largest == index){
                    //父亲节点的值大，循环比较完成
                    break;
                }
                //把大的孩子节点的值和父亲节点的值交换
                swap(arr, largest, index);
                index = largest;//指向孩子节点作为父亲节点继续比较
                left = 2 * index + 1;//继续招下一层的孩子节点
            }
        }

        /**
         * 交换父子节点位置的值
         * @param arr
         * @param i
         * @param j
         */
        private void swap(int[] arr, int i, int j){
            int value = arr[i];
            arr[i] = arr[j];
            arr[j] = value;
        }

        public String toString(){
            return JSONArray.toJSONString(heap);
        }
    }

    /**
     * 小根堆
     */
    public static class rightRootHeap{
        private int[] heap;
        private int heapSize;
        private int limit;

        public rightRootHeap(int limit){
            this.limit = limit;
            this.heapSize = 0;
            this.heap = new int[limit];
        }

        public boolean isFull(){
            return heapSize == limit;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public void push(int value){
            if(heapSize == limit){
                throw new RuntimeException("is full");
            }
            heap[heapSize++] = value;

        }

        public int pop(){
            int maxIndex = 0;
            for(int i=0; i< heapSize; i++){
                if(heap[i] > heap[maxIndex]){
                    maxIndex = i;
                }
            }
            int ans = heap[maxIndex];
            heap[maxIndex] = heap[--heapSize];
            return ans;
        }

    }


    public static void main(String[] args){
        int value = 10000;
        int limit = 1000;
        int testTiems = 100000;
        for(int i=0; i< testTiems; i++){
            int curLimit = (int)(Math.random() * limit + 1);
            MaxRootHeap my = new MaxRootHeap(curLimit);
            rightRootHeap test = new rightRootHeap(curLimit);
            int curOpTimes = (int)(Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if(my.isEmpty() != test.isEmpty()){
                    System.out.println("Oops!");
                }
                if(my.isFull() != test.isFull()){
                    System.out.println("Oops!");
                }
                if(my.isEmpty()){
                    int curValue = (int)(Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                }else if(my.isFull()){
                    if(my.pop() != test.pop()){
                        System.out.println("Oops!");
                    }
                }else {
                    if(Math.random() < 0.5){
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    }else {
                        if(my.pop() != test.pop()){
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
    }

}
