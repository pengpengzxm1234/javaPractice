package com.algorithmclassics;

/**
 * Created by px on 2017/9/29.
 * 题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 *
 */
public class algorithmclassics03 {

    public static void main(String[] args){
        int a = 0;//百位
        int b = 0;//十位
        int c = 0;//个位
        for(int i=101; i<1000; i++){
            a = i / 100;
            b = i % 100/10;
            c = i % 10;
            int sum = (a * a * a) + (b * b * b) + (c * c * c);
            if(sum == i){
                System.out.println("水仙花数：" + i);
            }
        }
    }
}
