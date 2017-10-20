package com.algorithmclassics;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by px on 2017/10/7.
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
public class algorithmclassics07 {

    public static void main(String[] args){
        int abcCount = 0;//英文字母个数
        int spaceCount = 0;//空格个数
        int numCount = 0;//数字个数
        int otherCount = 0;//其他个数

        System.out.println("请输入字符串");
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        char[] ch = str.toCharArray();

        for(int i=0 , len = ch.length; i<len; i++){
         if(Character.isLetter(ch[i])){
             //判断是否字母
             abcCount++;
             continue;
         }
         if(Character.isDigit(ch[i])){
             //判断是否数字
             numCount++;
             continue;
         }
         if(Character.isSpaceChar(ch[i])){
             //判断是否空格
             spaceCount++;
             continue;
         }
         otherCount++;
        }

    System.out.println("输入的字符"+ str + "中，有字母" + abcCount + "个；" + "数字" + numCount + "个；" +
            "空格" + spaceCount + "个；" + "其他" + otherCount + "个。");


    }
}
