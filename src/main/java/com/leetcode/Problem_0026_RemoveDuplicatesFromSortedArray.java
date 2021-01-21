package com.leetcode;

/**
 * leetcode高频讲解四
 * 去掉有序数组中重复的元素返回有效的长度
 * 要求：将不同的放到最前面，剩下的放到后面
 * 思路：使用两个指针，一个指向当前位置的cur 一个指向完成位置的done
 *     1、开始，done指向头部，cur指向第二个，如果相同，cur向后移动
 *     2、移动后，如果cur和done的值不同，done的下一个指针指向cur，done移动一个位置依次向后
 *     不同的时候，将不通的值和无用区的第一个值交换，done向后移动
 *
 */
public class Problem_0026_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        int done = 0;
        for(int i = 1; i< nums.length;i++){
            if(nums[i] != nums[done]){
                nums[++done] = nums[i];
            }
        }
        return done+1;
    }
}
