package dynamic_programming;

/**
 * @author yangchen
 * @date 2020/4/5 11:35-12.09
 * 总结：特判，状态更新。
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class _213_house_robber_ii {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        //这个特判必须加，应对只有一个房子的情况！！
        if (len == 1) return nums[0];
        int pre1 = 0;
        int pre2 = 0;
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int pre1 = 0;
        int pre2 = 0;
        int cur;
        for (int i = start; i <= end; i++) {
            cur = Math.max(pre1, pre2 + nums[i]);
            //状态更新要注意！！淘汰的量先被覆盖。
            pre2 = pre1;
            pre1 = cur;

            //这样是不对的，pre1 pre2都是cur的值。
//            pre1 = cur;
//            pre2 = pre1;
        }
        return pre1;
    }

    public static void main(String[] args) {
        _213_house_robber_ii solve = new _213_house_robber_ii();
        int[] arr = new int[]{2, 3, 2};
        System.out.println(solve.rob(arr));
    }

}
