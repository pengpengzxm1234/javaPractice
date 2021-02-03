package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * leetcode高频讲解六
 * 给定一个无重复的数组 生成所有不同的组合
 */
public class Problem_0046_Permutations {

    /**
     * 方法一：复杂度高，运行慢
     * 思路：循环递归让数组中的每一个数来到一个位置上，其余的后面排
     * 如[1,2,3]
     * 第一个循环就是让1， 2, 3分别占据0位置，递归排剩下的数
     */
    public static List<List<Integer>> onClass(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> rest = new HashSet<>();
        for(int num : nums){
            rest.add(num);
        }
        ArrayList<Integer> path = new ArrayList<>();
        f(rest, path, ans);
        return ans;
    }
    public static void f(HashSet<Integer> rest, ArrayList<Integer> path, List<List<Integer>> ans){
        if(rest.isEmpty()){
            ans.add(path);
        }else {
            for(int num : rest){
                ArrayList<Integer> curPath = new ArrayList<>(path);
                curPath.add(num);
                f(cloneExceptNum(rest, num), curPath, ans);
            }
        }
    }
    public static HashSet<Integer> cloneExceptNum(HashSet<Integer> rest, int num){
        HashSet<Integer> clone = new HashSet<>(rest);
        clone.remove(num);
        return clone;
    }


    /**
     * 解法2 换位组合
     */
    public static List<List<Integer>> permutations(int[] nums){
        if(nums.length == 0){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }

    public static void process(int[] nums, int index, List<List<Integer>> ans){
        if(index == nums.length){
            ArrayList<Integer> cur = new ArrayList<>();
            for(int num : nums){
                cur.add(num);
            }
            ans.add(cur);
        }else {
            for(int j = index; j< nums.length;j++){
                swap(nums, index, j);//和自己或者或后面的数交换位置
                process(nums, index + 1, ans);
                swap(nums, index, j);//还原，不还原会有问题
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
