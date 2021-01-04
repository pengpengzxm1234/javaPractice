package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode高频讲解一
 * 找到两个数和是指定值的数的位置
 */
public class Problem_0001_TwoSum {

    public static int[] twoSum(int[] nums, int target){
        //key 之前某个出现的数，value该数出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
