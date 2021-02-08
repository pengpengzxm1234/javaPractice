package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode高频讲解七
 * 旋转打印二维数组（可以是正方形，也可以是长方形）
 * (剥洋葱，一层一层来)
 */
public class Problem_0054_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return ans;
        }
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d){
            addEdge(matrix, a, b, c, d, ans);
        }
        return ans;
    }

    public static void addEdge(int[][] m, int a, int b, int c, int d, List<Integer> ans){
        if(a == c){
            for(int i = b; i< d; i++){
                ans.add(m[a][i]);
            }
        }else if(b == d){
            for(int i = a;i<c;i++){
                ans.add(m[i][b]);
            }
        }else {
            int curC = b;
            int curR = a;
            while (curC != d){
                ans.add(m[a][curC]);
                curC++;
            }
            while (curR != c){
                ans.add(m[curR][d]);
            }
            while (curC != b){
                ans.add(m[c][curC]);
                curC--;
            }
            while (curR != a){
                ans.add(m[curR][b]);
                curR--;
            }
        }
    }
}
