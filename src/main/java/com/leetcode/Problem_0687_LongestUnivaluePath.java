package com.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * leetcode高频讲解七
 * 二叉树相同值的连续节点的最长经过的路径
 * 两个相同节点之间的一个链接算一个路径距离
 */
public class Problem_0687_LongestUnivaluePath {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v){
            this.val = v;
        }
    }

    /**
     * 两个情况，一个是已x出发的最大距离，一个是与x无关，左右子树的最大距离
     * @param root
     * @return
     */
    public static int longestUnivalPath(TreeNode root){
        if(root == null){
            return 0;
        }
        return process(root).max - 1;//自定义的距离是节点个数，
    }

    //假设已x节点为头的数，返回的两个信息
    public static class Info{
        public int len;//路径必须以x出发，整棵树的合法路径的最大距离
        public int max;//不要求路径必须以x出发，整棵树的合法路径的最大距离

        public Info(int len, int max){
            this.len = len;
            this.max = max;
        }
    }

    public static Info process(TreeNode x){
        if(x == null){
            return new Info(0, 0);
        }
        TreeNode l = x.left;
        TreeNode r = x.right;
        Info linfo = process(l);//收集左树的信息
        Info rinfo = process(r);//收集右树的信息
        //x自己的len  1）路径只有x一个节点
        //x自己的max
        int len  = 1;
        if(l != null && l.val == x.val){
            len = linfo.len + 1;
        }
        if(r != null && r.val == x.val){
            len = Math.max(len, rinfo.len + 1);
        }
        int max = Math.max(Math.max(linfo.max, rinfo.max), len);

        if(l != null && r != null && l.val == x.val && r.val == x.val){
            max = Math.max(max, linfo.len + rinfo.len + 1);
        }
        return new Info(len, max);
    }


}
