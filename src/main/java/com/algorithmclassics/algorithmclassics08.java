package com.algorithmclassics;

import java.util.Scanner;

/**
 * Created by px on 2017/10/7.
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 */
public class algorithmclassics08 {

    public static void main(String[]  args){
        long a, b = 0, sum = 0;
        System.out.println("请输入数字");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println("输入相加的项数");
        int n = scanner.nextInt();
        int i = 0;
        while (i < n){
            b += a;
            sum += b;
            a = a * 10;
            i++;
            System.out.println("a = " + a + ";b=" + b + ";sum = " + sum);
        }
        System.out.println(sum);
    }
}
