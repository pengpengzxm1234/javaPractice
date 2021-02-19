package com.leetcode;

/**
 * leetcode高频讲解一
 * 给两个数字的链表，将两个链表对应的值相加得到一个新的数
 * 链表代表数据
 * 如：{2 -> 4 -> 3} + {5 ->6 ->4}
 * 输出 {7 -> 0 -> 8}
 * 即 342 + 465 = 807
 * 考点：操作链表，从头到尾依次到高位
 * 前提：每个节点的值都是小于10的
 */
public class Problem_0002_AddTwoNumbers {

    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int value){
            this.val = value;
        }
    }

    /**
     * 链表倒序链接，需要翻转链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addRTwoNumbers(ListNode head1, ListNode head2){
        int ca = 0;//进位
        int n1 = 0;//第一个链表加点的值
        int n2 = 0;//第二个链表节点的值
        int n = 0;//两个节点的与进位ca的和
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;//当前节点
        ListNode pre = null;//前置节点
        while (c1 != null || c2!= null){
            n1 = c1 != null? c1.val : 0;//当节点是空是，默认值是0
            n2 = c2 != null? c2.val : 0;//同上
            n = n1 + n2 + ca;//两个节点的值与进位值相加求和
            pre = node;//将当前节点赋值给pre，即现在这个节点不是新节点了
            node = new ListNode(n % 10);//新节点
            node.next = pre;//后面的节点指向前面的节点，及倒序链接
            ca = n / 10;//看是否有进位
            c1 = c1 != null ? c1.next : null;//向后遍历节点
            c2 = c2 != null ? c2.next : null;//向后遍历节点
        }
        if(ca == 1){//最后有进位
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return reverseList(node);//翻转链表
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 链表倒序链接，不翻转链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addRTwoNumbers1(ListNode head1, ListNode head2){
        int ca = 0;//进位
        int n1 = 0;//第一个链表加点的值
        int n2 = 0;//第二个链表节点的值
        int n = 0;//两个节点的与进位ca的和
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;//当前节点
        ListNode pre = null;//前置节点
        ListNode head = null;//记录头节点
        while (c1 != null || c2!= null){
            n1 = c1 != null? c1.val : 0;//当节点是空是，默认值是0
            n2 = c2 != null? c2.val : 0;//同上
            n = n1 + n2 + ca;//两个节点的值与进位值相加求和
            node = new ListNode(n % 10);//新节点
            if(head == null){
                pre = node;
                head = pre;
            }else {
                pre.next = node;
                pre = pre.next;
            }
            ca = n / 10;//看是否有进位
            c1 = c1 != null ? c1.next : null;//向后遍历节点
            c2 = c2 != null ? c2.next : null;//向后遍历节点
        }
        if(ca == 1){//最后有进位
            node = new ListNode(1);
            pre.next = node;
        }
        return head;//翻转链表
    }


}
