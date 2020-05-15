package dynamic_programming;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/8 18:19
 * https://leetcode-cn.com/problems/maximal-square/
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
/*
定义状态：dp[i][j]表示以i j 为右下角的正方形的最大边长。
转移方程：是 1 的位置，dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]),当前1的点边长取决于周围最小的边长

 */
public class _221_maximal_square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i+1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        int area = maxSide * maxSide;
        return area;
    }
}
