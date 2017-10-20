package com.algorithmclassics;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

/**
 * Created by px on 2017/10/11.
 * 题目：有1、2、3、4四个数字，能组成多少个互不相同且一个数字中无重复数字的三位数？并把他们都输入。
 */
public class algorithmclassics11 {
    public static void main(String[] args){
        int count  = 0;
        for(int i = 1; i<= 4; i++){
            for(int j = 1; j<=4;j++){
                for(int k = 1; k<=4; k++){
                    if(i!= j && i != k && k != j){
                        count ++;
                        System.out.println(100 * i + 10 * j + k);
                    }
                }
            }
        }
        System.out.println("共有" + count + "个三位数");
    }
}
