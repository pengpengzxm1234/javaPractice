package com.leetcode;

/**
 * leetcode高频讲解四
 * 数独填数，返回是否有效游戏
 * （每一行 每一列 每一个九宫格中 都不能出现重复的数字）
 */
public class Problem_0036_ValidSudoku {
    //检查有效游戏
    public static boolean isValidSudoku(char[][] board){
        boolean[][] row = new boolean[9][10];//行 1维代表行， 2维代表行上出现的数字
        boolean[][] col = new boolean[9][10];//列 1维代表列，2维代表列上出现的数字
        boolean[][] bucket = new boolean[9][10];//九宫格 1维代表第几个九宫格，2维代表九宫格上出现的数字
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; i++){
                int bid = i * (i / 3) + (j / 3);//计算出现在位置是第几个九宫格
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(row[i][num] || col[j][num] || bucket[bid][num]){//num已经存在于九宫格的i行，j列或者第bid个九宫格上
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
        return true;
    }
}
