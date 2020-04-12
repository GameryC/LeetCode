package dynamic_programming;

/**
 * @author yangchen
 * @date 2020/4/6 16:07 - 16.13
 */
public class _72_edit_distance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    //一维优化 16.25 - 16.43
    public int minDistance2(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len1 + 1];
        for (int i = 0; i <= len1 ; i++) {
            dp[i] = i;
        }
        //注意！！不是从1 开始了
//        for (int i = 0; i <= len2; i++) {
        for (int i = 1; i <= len2; i++) {
            int last = i - 1;
            dp[0] = i;
            for (int j = 1; j <= len1; j++) {
                int temp = dp[j];
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[j] = last;
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), last) + 1;
                }
                last = temp;
            }
        }
        return dp[len1];
    }
}
