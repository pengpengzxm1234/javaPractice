package com.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode高频讲解三
 * 合并n个有序的链表，新链表同样有序
 * 思路：利用小根堆（优先级队列就是小根堆实现）
 * 将所有链表的第一个节点放入小根堆中，没弹出一个节点，都将该节点
 * 的下一个节点放入小根堆中去，弹出的节点链接到新的链表上即可
 */
public class Problem_0023_MergeKSortedLists {

    public static class ListNode{
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for(ListNode head : lists){
            if(head != null){
                heap.add(head);
            }
        }
        if(heap.isEmpty()){
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if(pre.next != null){
            heap.add(pre.next);
        }
        while (head != null){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null){
                heap.add(cur.next);
            }
        }
        return head;
    }
}
