package com.algorithmclassics;

import java.util.Scanner;

/**
 * Created by px on 2017/10/11.
 * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，
 * 可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之
 * 间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，
 * 可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？
 */
public class algorithmclassics12 {
    public static void main(String[] args){
        System.out.println("输入奖金金额");
        Scanner scanner = new Scanner(System.in);
        double bonus = scanner.nextDouble();
        double out = 0;
        if(bonus > 0 && bonus <=  10){
            out = bonus * 0.1;
        }else if(10 < bonus && bonus <= 20){
            out = 10 * 0.1 + (bonus - 10) * 0.075;
        }else if(20 < bonus && bonus <= 40){
            out = 10 * 0.1 + 10 * 0.075 + (bonus - 20) * 0.05;
        }else if(40 < bonus && bonus <= 60){
            out = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (bonus - 40) * 0.03;
        }else if(60 < bonus && bonus <= 100){
            out = 20 * 0.175 + 20 * 0.05 + 20 * 0.03 + (bonus - 60) * 0.015;
        }else if(bonus > 100){
            out = 20 * 0.175 + 40 * 0.08 + 40 * 0.015 + (bonus - 100) * 0.01;
        }
        System.out.println("奖金金额是" + out + "万元");
    }

}
