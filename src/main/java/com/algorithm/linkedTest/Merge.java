package com.algorithm.linkedTest;

/**
 * 合并两个有序链表 自己手打
 */
public class Merge {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode head = null;
        if(list1.val >= list2.val){
            head = list2;
            list2 = list2.next;
        }else{
            head = list1;
            list1 = list1.next;
        }

        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else{
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;

        }
        cur.next = list1 == null ? list2 : list1;

        return head;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next = new ListNode(6);

        Merge(head1, head2);
    }
}
