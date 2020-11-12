package com.algorithm.tree;

/**
 * 三种二叉树的遍历（递归）
 * 1、先序遍历
 * 2、中序遍历
 * 3、后序遍历
 */
public class tree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int c){
            this.value = c;
        }
    }

    public static void f(Node head){
        if(head == null){
            return;
        }
        f(head.left);
        f(head.right);
    }

    /**
     * 先序遍历二叉树
     * 先输出根根节点 再输出左孩子 最后输出右孩子
     * @param head
     */
    public static void pre(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历二叉树
     * 左 - 》 中 -》 右
     */
    public static void in(Node head){
        if(head == null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 后序遍历
     */
    public static void pos(Node head){
        if(head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");

    }
}
