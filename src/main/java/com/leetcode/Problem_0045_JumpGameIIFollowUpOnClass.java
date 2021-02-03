package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * leetcode高频讲解六
 * 给定一个数组arr，长度是n
 * 给定一个想要出发的位置，再给定一个目标位置
 * 如果i位置的值是a，要么向左移动a步，要么向右移动a步
 * 问：需要多少步能到指定的位置，最优解
 * 思路：宽度优先遍历
 * 注意：重复的节点不要进队列
 */
public class Problem_0045_JumpGameIIFollowUpOnClass {

    public static int jumpMinTime3(int n, int start, int end, int[] arr){
        if(start < 1 || start > n || end < 1 || end > n){
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        //保存层及关系 key 位置(下标) value 层数，如果之前有记录，说明已经进入过队列，直接抛弃（去重）
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        queue.add(start);
        levelMap.put(start, 0);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            int level = levelMap.get(cur);
            if(cur == end){//弹出的位置和end位置相同
                return level;//在第几层，代表最少跳跃几次
            }else {
                int left = cur - arr[cur - 1];//start位置是从1开始的
                int right = cur + arr[cur - 1];
                if(left > 0 && !levelMap.containsKey(left)){//左侧不越界且没有出现过
                    queue.add(left);
                    levelMap.put(left, level +1);
                }
                if(right <= n && !levelMap.containsKey(right)){//右侧不越界且没有出现过
                    queue.add(right);
                    levelMap.put(right, level + 1);
                }
            }
        }
        //队列都弹完了也没有找到end
        return -1;
    }
}
