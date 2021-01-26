package com.leetcode;


/**
 * leetcode高频讲解五
 * 读出的数是下一个数
 * 1：“1” 读 1个1 因此 2就是
 * 2：“11” 读2个1 因此 3就是
 * 3： “21”读1个2 1个1
 * 4： “1211” 读 1个1 1个2 2个1
 * 5： “111221”
 */
public class Problem_0038_CountAndSay {
    /**
     *  给一个数n，即读第n个数
     *  即n读n-1，n-1读n-1-1，依次类推
     *  每个n n-1 n-1-1的结果都没有存，
     *  所以需要递归的读取到最开始的1然后再依次向上（递归）
     */
    public static String countAndSay(int n){
        if(n < 1){
            return "";
        }
        if(n == 1){
            return "1";
        }
        char[] last = countAndSay(n-1).toCharArray();//n要读取n-1
        StringBuilder ans = new StringBuilder();
        int times = 1;
        for(int i=1;i<last.length;i++){
            if(last[i - 1] == last[i]){
                times++;
            }else {
                ans.append(String.valueOf(times));
                ans.append(String.valueOf(last[i-1]));
                times = 1;
            }
        }
        ans.append(String.valueOf(times));
        ans.append(String.valueOf(last[last.length - 1]));
        return ans.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }

}
