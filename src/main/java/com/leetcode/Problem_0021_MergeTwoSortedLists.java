package com.leetcode;

/**
 * leetcode高频讲解三
 * 合并两个有序链表
 *
 */
public class Problem_0021_MergeTwoSortedLists {
    public static class ListNode{
        public int value;
        public ListNode next;
    }

    public static ListNode mergeTowList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l1 : l2;
        }
        ListNode head = l1.value <= l2.value ? l1 : l2;
        ListNode cur1 = head.next;//取头节点后剩余的节点
        ListNode cur2 = head == l1 ? l2 : l1;
        ListNode pre = head;//当前节点pre指向head链表的最后一个节点，用于拼接链表
        while (cur1 != null && cur2 != null){
            if(cur1.value <= cur2.value){
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;//移动pre到当前最后一个节点
        }
        pre.next = cur1 != null ? cur1 : cur2;//将没有遍历完的剩余节点接入pre
        return head;
    }
}
