package com.algorithm.binaryTree;

import sun.rmi.server.InactiveGroupException;

import java.util.Stack;
import java.util.regex.Matcher;

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
     * 利用栈来做到优先遍历左子树
     * @param head
     */
    public void preOrderUnRecur(Node head){
        System.out.print("pre_order:");
        if(null != head){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if(null != head.right){
                    stack.push(head.right);
                }
                if(null != head.left){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();

    }

    /**
     * 非递归——中序
     * @param head
     */
    public void inOrderUnRecur(Node head)throws Exception{
        System.out.print("in_order:");
        if(null != head){
            Stack<Node> stack = new Stack<>();
            while (head != null || !stack.isEmpty()){
                if(null != head){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归——后序
     * 利用两个栈实现s1 s2
     * 将头节点压如s1，
     * 从s1中弹出节点记为cur，依次将cur的左节点、右节点压入s1.同时 cur 压入s2；重复这步骤，直到s1为空
     * （先从s1中弹出的会先压入s2中，这样在打印s2的时候，先弹出s1的那个节点就会后弹出，
     *   由于最后要先输出的是左节点，因此，左节点要先压入s1中，这样在s2中就能后入栈）
     * 打印s2；
     * @param head
     */
    public void postOrderUnRecur1(Node head){
        System.out.print("post_order:");
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

    /**
     * 非递归——后序遍历二叉树
     * 利用一个栈实现
     * @throws Exception
     * @Param head 最近一次被弹出并打印的节点
     *        c    栈顶节点
     *
     *  c的左节点不为空 h 对比 c的左、右节点，都不相同，则节点还未打印，此时将c的左节点入栈，
     *  c的右节点不为空 h 对比 c的右节点，值不相同，则有节点未打印，此时将c的右节点入栈
     *  上面两个条件都不符合，从站中弹出一个节点并打印，并将改节点赋值给h
     */
    public void postOrderUnRecur2(Node head){
        if(head == null){return;}
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node c = null;
        while (!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && head != c.left && head != c.right){
                stack.push(c.left);
            }else if(c.right != null && head != c.right){
                stack.push(c.right);
            }else {
                System.out.print(stack.pop().value + " ");
                head = c;
            }
        }
        System.out.println();
    }


    /**
     * 二叉树最小深度
     * 递归方法（利用系统栈）
     * 额外空间为系统栈的高度
     * @param head
     */
    public Integer minDepth1(Node head){
        if(null == head){return 0;}
        return process(head, 1);
    }

    public Integer process(Node node, Integer level){
        if(node.left == null && node.right == null){//找到了叶子节点
            return level;
        }
        Integer ans = Integer.MAX_VALUE;
        //遍历所有的节点，找到叶子节点，并比较叶子节点高度，取小的
        if(node.left != null){
            ans = Math.min(process(node.left, level + 1), ans);
        }
        if(node.right != null){
            ans = Math.min(process(node.right, level + 1), ans);
        }

        return ans;
    }


    public static void main(String[] args)throws Exception{
        Node node = new TraverseBinaryTree.Node(5);
        node.left = new TraverseBinaryTree.Node(3);
        node.right = new TraverseBinaryTree.Node(6);
        node.right.right = new TraverseBinaryTree.Node(7);
        TraverseBinaryTree tree = new TraverseBinaryTree();
       /* tree.preOrderRecur(node);
        tree.posOrderRecur(node);
        */
        //tree.inOrderRecur(node);
        tree.preOrderUnRecur(node);
        System.out.println();
        tree.inOrderUnRecur(node);
        tree.postOrderUnRecur1(node);
        tree.postOrderUnRecur2(node);
        System.out.print(tree.minDepth1(node));
    }
}
