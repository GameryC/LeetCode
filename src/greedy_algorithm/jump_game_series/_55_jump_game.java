package greedy_algorithm.jump_game_series;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/4 9:59
 * https://leetcode-cn.com/problems/jump-game/
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
/*
思路：记录一个当前位置能跳到的最大距离，如果当前位置超出了以前的最大距离，就是false；走到最后没有报错，
说明所有位置都在最大距离中，true。
 */
public class _55_jump_game {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }
}