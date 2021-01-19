package com.leetcode;

/**
 * leetcode高频讲解三
 * 链表
 * 删除倒数第N个节点
 * 要返回新的头节点（头节点有可能被删除）
 * 思路：先数够n个，即通过快慢指针来操作，
 *      r指针先数够n，然后l从头开始遍历，这时l和r同时移动
 *      当r到达链表尾部节点时，l的位置就是要删除节点的位置
 *      （需要找到这个节点前一个节点,找到要删除的节点是无法删除该节点的）
 *      因此要让指针指向前一个节点
 */
public class Problem_0019_RemoveNthNodeFromEndofList {
    public static class ListNode{
        public int val;
        public ListNode next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode cur = head;
        ListNode pre = null;
        boolean enough = false;
        while (cur != null){//找到要删除节点的前一个节点
            n--;
            if(n <= 0){
                if(n == 0){
                    enough = true;
                }else if(n == -1){
                    pre = head;
                }else {//和cur同时向后移动节点
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }
        if(!enough){
            return head;
        }
        if(pre == null){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            n--;
            if(n <= 0){
                if(n == -1){//cur到了n+1位置，准备移动pre指针
                    pre = head;
                }else {
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }
        if(n > 0){
            return head;
        }
        if(pre == null){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
