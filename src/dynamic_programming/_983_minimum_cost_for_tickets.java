package dynamic_programming;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/6 10:20
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * 983. 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 *
 *
 * 示例 1：
 *
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 *
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *
 *
 * 提示：
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
/*
思路：
用dp,有两种考虑方法，①dp[i]表示到第i天为止花费的最少钱，②dp[i]表示从i天开始到最后花费的最少钱。感觉第一种更好理解。
第一种做法：
根据出行的日子，生成最大长度的dp数组，其中标记要出行的日子。
遍历dp数组，
    如果不出行，该天和前一天花费一样，即不买票
    如果要出行，有三种买票方式，
        买当天票
        买两天票，如果大于两天让两天前买两天票
        买七天票，如果大于七天让七天前买七天票
返回最后一天的花费。
 */
public class _983_minimum_cost_for_tickets {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) return 0;
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        // 标记一下出行的日子
        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = Integer.MAX_VALUE;
        }
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int buy7 = Integer.MAX_VALUE;
        for (int i = 1; i <= maxDay; i++) {
            // 说明这天不要出行，不用买票，这天的花费和前一天一样
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            // 买一天票，在前一天花费的基础上加一天票 票价
            buy1 = costs[0] + dp[i - 1];
            // 大于七天的话，七天前买一张七日票，
            // 不大于七天，第一天就买一张七日票！！！！
            buy2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            buy7 = i > 30 ? dp[i - 30] + costs[2] : costs[2];
            dp[i] = Math.min(Math.min(buy1, buy2), buy7);

        }
        return dp[maxDay];
    }

}
