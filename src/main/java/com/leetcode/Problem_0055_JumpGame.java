package com.leetcode;

/**
 *  leetcode高频讲解六
 *  跳跃游戏
 *  是否能从0位置跳跃到n-1位置，每个位置上的值代表最多可以跳跃的单位
 *  思考：存在一个选择问题
 */
public class Problem_0055_JumpGame {

    public static boolean canJump(int[] nums){
        if(nums == null || nums.length == 0){
            return true;
        }
        int max = nums[0];//取0位置的值作为初始值，表示目前位置能够跳跃到的最右位置
        //每一步判断是否可以到达改位置，及 i > max retrun false
        for(int i = 1; i < nums.length; i++){
            /*if(max >= nums.length - 1){
                return true;
            }*/
            if(i > max){
                return false;
            }
            max = Math.max(max, i + nums[i]); //i + num[i] 代表i位置开始能够到达的最右位置
        }
        return true;
    }
}
