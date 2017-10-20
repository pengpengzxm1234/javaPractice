package com.main.simplefactorymode;

import java.util.Scanner;

/**
 * Created by px on 2017/7/1.
 */
public class MainClass {

    public static void main(String[] args){
        String[] numbers = inPutNumber();
        Operation operation = SimpleFactoryMode.createOperate(numbers[2]);
        operation.setNumberA(Double.parseDouble(numbers[0]));
        operation.setNumberB(Double.parseDouble(numbers[1]));
        operation.getResult();
        System.out.println("计算结果是：" + operation.getResult());
    }

    /**
     * 输入要排序的数字，没有排除重复
     * @return
     */
    private static String[] inPutNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("输入第一个数字");
        String numberA = input.next();
        System.out.println("输入第二个数字");
        String numberB = input.next();
        System.out.println("输入要执行的运算 加：+ 减：- 乘：* 除：/");
        String operate = input.next();
        String[] num = new String[3];
        num[0] = numberA;
        num[1] = numberB;
        num[2] = operate;
        return num;
    }
}
