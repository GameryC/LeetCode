package jian_zhi_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/7 17:19
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class _59_max_sliding_window {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) return new int[]{};
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> qMax = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i])
                qMax.pollLast();
            qMax.addLast(i);
            if (qMax.peekFirst() == (i - k))
                qMax.pollFirst();
            if (i >= (k - 1))
                // 这里添加队列头部的结果，用 peek 不用 poll！
                res[index++] = nums[qMax.peekFirst()];
        }
        return res;
    }
}
