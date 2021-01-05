package com.leetcode;

/**
 * leetcode高频讲解二
 * 数字转成罗马数字 限定范围不超过4000
 * 注：本题与13题是成对的
 * 如：1 -> I
 *    5 -> V
 *    10 -> X
 *    50 -> L
 *    100 -> C
 *    500 -> D
 *    1000 -> M
 */
public class Problem_0012_IntegerToRoman {

    public static String intToRoman(int num){
        String[][] c = {
                {"","I","II","III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM" } };
        StringBuffer roman = new StringBuffer();
        roman.append(c[3][num / 1000 % 10])
                .append(c[2][num / 100 % 10])
                .append(c[1][num / 10 % 10])
                .append(c[0][num % 10]);
        return roman.toString();
    }

    public static void main(String[] args){
        System.out.println(2940 / 100 );
        System.out.println(2940 / 100 % 10);
        System.out.println(intToRoman(3912));
    }
}
