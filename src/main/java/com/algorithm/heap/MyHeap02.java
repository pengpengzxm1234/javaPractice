package com.algorithm.heap;

import java.util.*;

/**
 * list集合实现一个堆，改变堆中的值，堆进行相应的调整，使其满足最的条件
 * 带泛型的堆
 * 小根堆
 */
public class MyHeap02 {

    public static
    class MyHeap<T>{
        private ArrayList<T> heap;
        private Integer heapSize;
        private Map<T, Integer> map;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com){
            heap = new ArrayList<T>();
            this.comparator = com;
            heapSize = 0;
            map = new HashMap<>();
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public int size(){
            return heapSize;
        }

        public void push(T value){
            heap.add(value);
            map.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public T pop(){
            T ans = heap.get(0);
            int end = heapSize - 1;
            swap(0 , end);
            heap.remove(end);
            map.remove(ans);
            heapify(0, --heapSize);
            return ans;
        }


        /**
         *找到父亲节点向上比较，直到节点大于父亲节点的值
         * @param index
         */
        private void heapInsert(int index){
            while (comparator.compare(heap.get(index), heap.get((index - 1)/2)) < 0){
                swap(index, (index - 1)/2);
                index = (index + 1)/2;
            }
        }

        /**
         * 重新配列成满足大根堆条件的列表
         * @param index
         * @param heapSize
         */
        private void heapify(int index, int heapSize){
            int left = index * 2 +1;
            while (left < heapSize){
               int largest = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1: left;
               largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
               if(largest == index){
                   break;
               }
               swap(largest, index);
               index = largest;//变换节点位置
               left = index * 2 + 1;//找到下一个左孩子节点
            }
        }

        private void swap(int i, int j){
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(j, o1);
            heap.set(i, o2);
            map.put(o2, i);
            map.put(o1, j);
        }

    }

    public static class Student{
        public int classNo;
        public int age;
        public int id;

        public Student(int classNo, int age, int id){
            this.classNo = classNo;
            this.age = age;
            this.id = id;
        }
    }

    public static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args){
        Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        Student s4 = null;
        Student s5 = null;
        Student s6 = null;

        s1 = new Student(2, 50, 11111);
        s2 = new Student(1, 60, 22222);
        s3 = new Student(6, 10, 33333);
        s4 = new Student(3, 20, 44444);
        s5 = new Student(7, 72, 55555);
        s6 = new Student(1, 14, 66666);

        //PriorityQueue（优先级队列）底层结构是用堆来实现的
        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        heap.add(s6);
        while (!heap.isEmpty()) {
            Student cur = heap.poll();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }

        System.out.println("===============");

        MyHeap<Student> myHeap = new MyHeap<>(new StudentComparator());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);
        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.classNo + "," + cur.age + "," + cur.id);
        }
    }

}
