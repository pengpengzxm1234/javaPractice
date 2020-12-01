package com.algorithm.linkedTest;

public class LinkedList {
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            this.value = data;
        }
    }

    /**
     * 问题：给定两个有序链表的头节点head1， head2，打印两个链表的公共部分
     * 分析：链表有序，因此从两个链表的头开始进行如下判断
     * 1、如果head1的值小于head2，则head1向下移动
     * 2、如果head2的值小于head1，则head2向下移动
     * 3、如果head1的值与head2的值相同，则打印这个值，然后head1和head2都时向下移动，
     * 4、head1或head2有任何一个移动到null，则整个过程停止
     */
    public void printCommonPart(Node head1, Node head2){
        System.out.print("Common Part:");
        while (head1 != null && head2 != null){
            if(head1.value < head2.value){
                head1 = head1.next;
            }else if(head2.value < head1.value){
                head2 = head2.next;
            }else {
                System.out.print(head1.value +" ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    /**
     * 在单链表和双链表中删除倒数第k个节点
     * 解析：让链表从头走到尾，每移动一步，k的值减1，当链表走到结尾时，
     * 1、k > 0，说明不用调整整个链表，链表没有倒数第k个节点
     * 2、k = 0，说明链表倒数第k个节点是头节点，返回head.next
     * 3、k < 0，
     *    1）重新重头节点开始走，每移动一步，k + 1，
     *    2）当k=0是，移动停止，移动到的节点就是要删除节点的前一个节点
     */
    public Node removeLastKthNode(Node head, int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            lastKth--;
            cur = head.next;
        }
        if(lastKth == 0){
            head = head.next;
        }
        if(lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 双链表和单链表处理方式一样，注意last指针重连即可
     */
    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth){
        if(head == null || lastKth <1){
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth == 0){
            head = head.next;
            head.last = null;
        }
        if(lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = head.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

    /**
     * 反转单向和双向链表
     */
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 单链表的选择排序
     * 问题：给定一个无序单链表的头节点head，实现单链表的选择排序
     * 要求：额外空间复杂度为O(1)
     */
    public Node selectionSort(Node head){
        Node tail = null;//排序部分尾部
        Node cur = head;//未排序部分头部
        Node smallPre = null;//最小节点的前一个节点
        Node small = null;//最小的节点
        while (cur != null){
            small = cur;
            smallPre = getSamllestPreNode(cur);
            if(smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;//删除最小节点，链接剩余部分
            }
            cur = cur == small ? cur.next : cur;
            if(tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public Node getSamllestPreNode(Node head){
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if(cur.value < small.value){
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }


}
