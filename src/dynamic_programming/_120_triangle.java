package dynamic_programming;

import java.util.List;

/**
 * @author yangchen
 * @date 2020/3/28 18:04
 */
//自底向上
public class _120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.size();// 一定是正方形
        int[][] dp = new int[row][col];
        for (int i = 0; i < col ; i++) {
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        }
        for (int i = row - 2; i >=0 ; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + list.get(j);
            }
        }
//        for (int i = 0; i < col; i++) {
//            res = Math.min(dp[row - 1][i], res);
//        }
        return dp[0][0];
    }

    //一维数组，
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {

    }
}
