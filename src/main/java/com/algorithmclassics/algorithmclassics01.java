package com.algorithmclassics;

/**
 * Created by px on 2017/9/28.
 * 50道经典算法一：
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 算法分析：以对为单位，1-2个月的个数为1；三个月生一对，数量为2（1+1）；第四个月，第一对小兔子再生一对，加上上个月生的一对，总数为3（1+2）；第五个月，最开始的两对兔子
 * 分别生一对，加上原来的三对，总数为5对（2+3）。因此，上上个月的兔子，加上上个月额兔子数，就是这个月兔子的总对数
 * 因此，总数为：1，1，2，3，5，8，13，21。。。
 *
 **/
public class algorithmclassics01 {

    public static void main(String[] arts){
        int a=0;
        int b=1;//第一个月有一堆兔子
        System.out.println("第1个月兔子总数：" + b + "对");
        for(int i=0; i<=12; i++){
            int c = a + b;
            a = b;
            b = c;
            System.out.println("第" + (i+2) + "个月兔子总数：" + c + "对"+ Math.sqrt(101));
        }
    }
}
