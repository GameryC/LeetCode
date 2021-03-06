package dynamic_programming;

import java.util.Arrays;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/28 11:42
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class _322_coin_change {
    // 23ms 35% , 5.77%
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                if ((i - coin >= 0) && dp[i - coin] != amount + 1) {
//                    // 因为一开始就赋值为大的不可能的值了
//                    // 转移方程记得加一
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
