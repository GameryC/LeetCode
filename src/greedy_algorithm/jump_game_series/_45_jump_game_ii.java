package greedy_algorithm.jump_game_series;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/4 10:11
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
/*
思路：
贪心算法，每到一个点，选择该点能到达的点中，跳跃距离最远的点，步数加一
维持一个范围变量end,最大距离maxPosition, 到end位置步数加一，end更新为maxPosition;
 */
public class _45_jump_game_ii {
    public int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int maxPosition = 0;
        int len = nums.length;
        // 不遍历最后一个元素。这个元素的值不影响结果，反而当是end位置时，会使step+1出错。
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(i + nums[i], maxPosition);
            if (end == i) {
                step++;
                end = maxPosition;
            }
            if (maxPosition >= len - 1) {
                return step;
            }
        }
        return step;
    }
}
