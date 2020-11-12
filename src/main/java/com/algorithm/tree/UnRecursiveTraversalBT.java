package com.algorithm.tree;

import java.util.Stack;

/**
 * 二叉树的三种遍历（非递归）
 */
public class UnRecursiveTraversalBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int c){
            this.value = c;
        }
    }

    /**
     * 先序遍历二叉树
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        if(null == head){return;}
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.print(head.value + " ");
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head){
        if(null == head){return;}
        Stack<Node> stack = new Stack<>();
        while (null != head || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head){
        if(null == head){return;}
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            if(head.left != null){
                stack1.push(head.left);
            }
            if(head.right != null){
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        preOrderUnRecur(head);
        System.out.println("========");
        inOrderUnRecur(head);
        System.out.println("========");
        posOrderUnRecur1(head);
        System.out.println("========");

    }
}