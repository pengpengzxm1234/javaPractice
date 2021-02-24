package com.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断二叉树对称
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Problem_0101_SymmetricTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){}

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode head1, TreeNode head2){
        if(head1 == null && head2 == null){
            return true;
        }
        if(head1 != null && head2 != null){
            return head1.val == head2.val && isMirror(head1.left, head2.right)
                    && isMirror(head1.right, head2.left);
        }
        return false;
    }

    /**
     * 非递归方法
     * 双端队列实现
     */
    public static boolean isSymmetric1(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.right != null){
            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode left = root.left;
            TreeNode right = root.right;
            deque.addFirst(left);
            deque.addLast(right);
            while (!deque.isEmpty()){
                left = deque.pollFirst();
                right = deque.pollLast();
                if(left != null && right != null && left.val == right.val){
                    if(left.left != null && right.right != null && left.left.val != right.right.val){
                        return false;
                    }
                    if(left.right != null && right.left != null && left.right.val != right.left.val){
                        return false;
                    }
                    deque.addFirst(left.left);
                    deque.addLast(right.right);
                    deque.addFirst(left.right);
                    deque.addLast(right.left);
                }else if(left == null && right == null){
                    continue;
                }else {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric1(root));

    }
}
