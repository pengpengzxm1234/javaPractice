package com.algorithmclassics;

/**
 * Created by px on 2017/9/28.
 * 题目：判断101-200之间有多少个素数，并输出所有素数。
 *
 * 素数定义： 若正整数a>1,且a不能被不超过a的平方根的任一素数整除，则a是素数
 */
public class algorithmclassics02 {

    public static void main(String[] args){
        int count = 0;
        for(int i = 101; i<200; i++){
            boolean flag = true;//默认是素数
            System.out.print("当前数字：" + i);
            for(int j = 2; j<Math.sqrt(i);j++){//根据素数的定义，验证是否时素数
                int result = i % j;
                if(0 == result){
                    flag = false;
                    break;
                }
            }
            if(flag){//flag为true，不是素数
                count +=1;
                System.out.println(" 是素数，现在素数总数为" + count);
            }else{
                System.out.println("");
            }
        }
        System.out.println("101-200之间素数的个数：" + count + "个");
    }
}
