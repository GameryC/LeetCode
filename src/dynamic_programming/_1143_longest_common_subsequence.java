package dynamic_programming;

/**
 * @author yangchen
 * @date 2020/3/28 17:36
 * 12.03 动态规划
 */

public class _1143_longest_common_subsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] =dp [i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return  dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","abc"));
    }
}
