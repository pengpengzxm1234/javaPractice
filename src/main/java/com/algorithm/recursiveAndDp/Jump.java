package com.algorithm.recursiveAndDp;

/**
 * 跳跃游戏
 * 给定数据Arr， arr[i]==k代表可以从位置i向右跳1~k个距离。比如，arr[2] == 3，代表可以从位置2跳到位置3，位置4，位置5.
 * 如果从位置0出发，返回最少跳几次能跳到arr最后的位置上
 * 要求：如果arr长度为N,要求实现时间复杂度为O(N)、额外空间复杂度为O(1)的方法
 */
public class Jump {
    public int jump(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int jump = 0;//目前跳了多少步
        int cur = 0;//如果跳jump步，最远能到达的位置
        int next = 0;//如果再跳一步，最远能到达的位置
        for(int i=0; i< arr.length; i++){
            if(cur < i){//跳jump步不能到达i位置，需要多跳一步才行
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);//下一次多跳一步能到的最远的位置， i+arr[i]当前位置能往后跳到的最远位置
        }
        return jump;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,2,3,1,1,4};
        System.out.println(new Jump().jump(arr));
    }
}
