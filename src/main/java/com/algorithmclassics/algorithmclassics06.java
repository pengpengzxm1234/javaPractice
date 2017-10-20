package com.algorithmclassics;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import java.util.Scanner;

/**
 * Created by px on 2017/9/30.
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * 分析： 在循环中，只要除数不等于0，用较大数除以较小的数，将小的一个数作为下一轮循环的大数，
 *        取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回较大的数，
 *        此数即为最大公约数，最小公倍数为两数之积除以最大公约数。
 */
public class algorithmclassics06 {

    public static void main(String[] args){
        System.out.print("输入第一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int numA = scanner.nextInt();
        System.out.print("输入第二个正整数：");
        int numB = scanner.nextInt();
        int m = 0;
        int max = 0;//最大公约数
        int min = 0;//最小公倍数

        m = numA;
        if(numA <= numB){//如果A《B，两个数互换
            numA = numB;
            numB = m;
        }

        max = numA;
        min = numB;

        while(m >= 0){
            if(0 == m){
                m = numA;
                break;
            }else if(0 != numB){
                m = numA % numB;
                numA = numB;
                numB = m;
            }
        }
        System.out.print(max + "和" + min);
        min = max * min / m;
        max = m;
        System.out.println("最大公约数是：" + max + "，最小公倍数是：" + min);
    }

}
