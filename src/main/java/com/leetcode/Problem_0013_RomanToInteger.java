package com.leetcode;

/**
 * leetcode高频讲解二
 * 罗马数字转整型数字
 * 遍历字符串，如果i位置的数字小于i+1位置的数字，给i位置上的数字取反
 * 然后每个位置上的数字转换相加，累加的结果就是转换后的值
 */
public class Problem_0013_RomanToInteger {

    public static int romanToInt(String s){
        int[] nums = new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M' :
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] < nums[i+1]){
                sum -= nums[i];
            }else {
                sum += nums[i];
            }
        }
        return sum;
    }
}
