package com.leetcode;

/**
 * leetcode高频讲解七
 * 旋转图片（正方形）
 * 围绕中心点旋转90度
 * 用有限变量搞定
 */
public class Problem_0048_RotateImage {

    /**
     * 思路：顺时针转90度只是外层的一圈相互节点的互换
     * 从外层的一圈开始依次向内部处理
     */
    public static void rotate(int[][] matrix){
        //定义左上角点和右下角点。用来表示一个圈
        //不同的圈都处理一遍
        int tR = 0;//左上角点
        int tC = 0;
        int dR = matrix.length - 1;//右下角点
        int dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     *  → → →  →
     * ↑         ↓
     * ↑         ↓
     * ↑         ↓
     * ↑         ↓
     *  ← ← ←  ←
     * @param m
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC){
        int times = dC - tC;//计算有多少组
        int tmp = 0;
        for(int i=0; i!= times; i++){
            tmp = m[tR][tC + i];//上行
            m[tR][tC + i] = m[dR - i][tC];//左列
            m[dR - i][tC] = m[dR][dC - i];//下行
            m[dR][dC - i] = m[tR + i][dC];//右列
            m[tR + i][dC] = tmp;
        }
    }


}
