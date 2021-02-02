package com.leetcode;

/**
 *  leetcode高频讲解六
 *  和55题绑定在一起讲
 *  从0位置跳跃到n-1位置，返回至少跳跃次数
 *
 */
public class Problem_0045_JumpGameII {

    /**
     * step  当前最少跳几步能到i
     * cur   跳的步数不超过step，最右能到的位置
     * next   跳的步数不超过step+1步，最右能到的位置
     *
     * i> cur, step现在的步数不足以到i step++;
     * i<= cur, step步内，可以到i
     * @param arr
     * @return
     */
    public static int jump(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int step = 0;
        int cur = 0;
        int next = arr[0];
        for(int i=1; i<arr.length;i++){
//            if(next >= arr.length - 1){
//                return step + 1;
//            }
            if(cur < i){
                step++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return step;
    }
}
