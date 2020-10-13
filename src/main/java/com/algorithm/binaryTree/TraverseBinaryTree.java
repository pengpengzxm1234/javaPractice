package com.algorithm.binaryTree;

/**
 * 二叉树遍历
 * 1、递归
 * 2、非递归
 * 先序(根、左、右)
 * 中序（左、根、右）
 * 后序（左、右、根）
 */
public class TraverseBinaryTree {
    /**
     * 定义节点类
     */
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 递归——先序遍历二叉树
     */
    public void preOrderRecur(Node head){
        if(null == head){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 递归——中序遍历二叉树
     * @param head
     */
    public void inOrderRecur(Node head){
        if(null == head){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 递归——后序
     * @param head
     */
    public void posOrderRecur(Node head){
        if(null == head){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归——先序遍历
     * @param head
     */
    public void preOrderUnRecur(Node head){


    }

    /**
     * 非递归——中序
     * @param head
     */
    public void inOrderUnRecur(Node head){

    }

    /**
     * 非递归——后序
     * @param head
     */
    public void postOrderUnRecur(Node head){

    }

    public static void main(String[] args){
        Node node = new TraverseBinaryTree.Node(5);
        node.left = new TraverseBinaryTree.Node(3);
        node.right = new TraverseBinaryTree.Node(6);
        TraverseBinaryTree tree = new TraverseBinaryTree();
        tree.preOrderRecur(node);
        System.out.println("=====");
        tree.inOrderRecur(node);
        System.out.println("=====");
        tree.posOrderRecur(node);

    }
}
