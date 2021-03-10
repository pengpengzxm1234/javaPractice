package com.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Problem_0092_ReverseListMtoN {
    public static class ListNode {

      int val;

      ListNode next;

      ListNode() {}

      ListNode(int val) { this.val = val; }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        if(left == right){
            return head;
        }

        ListNode preNode = null;
        ListNode next = null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tail = null;
        int i = 1;
        while (i <= right){
            if(i < left){
                preNode = cur;
                cur = cur.next;
            }else if(i >= left && i <= right){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                if(i == left){
                    tail = pre;
                }
            }
            i++;
        }
        if(preNode != null){
            preNode.next = pre;
        }
        tail.next = cur;
        return preNode != null ? head : pre;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        /*node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);*/
        ListNode ans = reverseBetween(node, 1, 2);
        System.out.println("done");
    }
}
