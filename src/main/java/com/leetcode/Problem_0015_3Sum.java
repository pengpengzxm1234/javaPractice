package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode高频讲解三
 * 三和问题：一个数组arry，三个不同元素相加和是0，返回数组中所有的不同的组合
 * 一、二元组问题（两个数相加为指定值k的不同的组合的求解）
 * 1）数组排序
 * 2）用连个指针l和r 分别从数组的开头和结尾遍历数组
 *    移动条件：l + r > k,r向左移动
 *             l + r <k, l向右移动
 *             l + r == k, l向右移动（如果l向右移动的值和前一位相同,则是相同的组合，这样可以排除重复的组合）
 * 二、三和问题 :三个数相加和为0的组合
 * 1）数组排序
 * 2）用给一个指针p，从左向右遍历，每个位置，相当于在数组后面的值中，找一个二元组，
 * 3）如果p调到下一个位置，且p和前一个值相同，直接跳过，因为前面的值已经求过了所有的二元组
 */
public class Problem_0015_3Sum {

    public static List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //第一个数选了i位置的数
        for(int i=0; i< nums.length - 2; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                List<List<Integer>> nexts = twoSum1(nums, i+1, -nums[i]);
                for(List<Integer> cur : nexts){
                    cur.add(0, nums[i]);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    /**
     * 两和问题
     * nums[begin...]范围上，找到累加和为target的所有二元组
     * nums已经有序
     */
    public static List<List<Integer>> twoSum1(int[] nums, int begin, int target){
        int L = begin;
        int R = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R){
            if(nums[L] + nums[R] > target){
                R--;
            }else if(nums[L] + nums[R] < target){
                L++;
            }else {
                //判断当前位置的值是否和前一位的值相同，相同跳过
                if(L == begin || nums[L - 1] != nums[L]){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(L);
                    cur.add(R);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }
}
