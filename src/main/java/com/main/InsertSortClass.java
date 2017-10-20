package com.main;

import java.util.Scanner;

/**
 * Created by px on 2017/3/18.
 * 算法练习——插入排序算法
 */
public class InsertSortClass {

    public static void main(String[] args){
        int[] nums = inPutNumber();
        int[] sorted = insertSort(nums);
        String sortArry = turnString(sorted);
        System.out.println("（升序）排序后的数字顺序：" + sortArry);
        int[] sortedDown = insertSortDown(nums);
        String sortArrayDown = turnString(sortedDown);
        System.out.println("（降序）排序后的数字顺序：" + sortArrayDown);
    }

    /**
     * 数组转为字符串
     */
    private static String turnString(int[] sorted){
        String sortArry = "";
        for(int i=0,len = sorted.length;i<len;i++){
            if(i==(len-1)){
                sortArry += String.valueOf(sorted[i]);
            }else{
                sortArry += String.valueOf(sorted[i]) + ",";
            }
        }
        return sortArry;
    }

    /**
     * 输入要排序的数字，没有排除重复
     * @return
     */
    private static int[] inPutNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("输入要排序的数字，用逗号间隔！");
        String numbers = input.next();
        System.out.println("输入的数字:" + numbers);
        String[] numArray = numbers.split(",");
        int[] num = new int[numArray.length];
        for(int i=0,len = numArray.length;i<len;i++){
            num[i] = Integer.parseInt(numArray[i]);
        }
        return num;
    }

    /**
     * 插入排序（升序）
     */
    private static int[] insertSort(int[] sort){
        int key = 0;
        int i = 0;
        for(int j=1,len = sort.length;j<len;j++){
            key = sort[j];
            i = j - 1;
            while(i>=0 && sort[i]>key){
                sort[i+1] = sort[i];
                sort[i] = key;
                i--;
            }
        }
        return sort;
    }

    /**
     *插入排序（降序）
     *
     */
    private static int[] insertSortDown(int[] sort){
        int key = 0;
        int i = 0;
        for(int j = 1,len = sort.length;j<len;j++){
            key = sort[j];
            i = j - 1;
            while(i>=0 && sort[i]<key){
                sort[i+1] = sort[i];
                sort[i] = key;
                i--;
            }
        }
        return sort;
    }

}
