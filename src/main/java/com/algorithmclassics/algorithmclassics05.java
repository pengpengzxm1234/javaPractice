package com.algorithmclassics;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import java.util.Scanner;

/**
 * Created by px on 2017/9/30.
 * 题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */
public class algorithmclassics05 {

    public static  void main(String[] args){
        System.out.print("请输入学生成绩：");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        String gradle = score >= 90 ? "A ": score > 60 ? "B" : "C";
        System.out.println("学生成绩的等级是：" + gradle);
    }
}
