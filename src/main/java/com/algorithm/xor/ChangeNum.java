package com.algorithm.xor;

/**
 * 异或（相异为1 相同为0）
 * 不用任何变量实现两个数交换
 * 1）N ^ 0 = N
 * 2）N ^ N = 0
 * 3）异或满足交换律和结合律（多个值异或不论顺序，结果一样）
 * a=甲 b=乙
 * a = 甲 ^ 乙
 * b = 甲^乙^乙 = 甲
 * a = 甲^乙^甲 = 乙
 */
public class ChangeNum {
    public static void swap(int a, int b){
        System.out.println("a = " + a +",b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a +",b=" + b);
    }

    public static void main(String[] args){
        swap(1,2);
    }
}
