package jian_zhi_offer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/9 9:39
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 面试题39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *
 */
/*
摩尔投票法：假设一个数字是众数，遍历每一个数，统计众数的频次，和遍历的数一样频次+1，不一样频次-1；
频次为零的时候换当前数为假设众数，
 */
public class _39_majority_element {
    public int majorityElement(int[] nums) {
        int res = 0;
        int votes = 0;
        int cnt = 0;
        for(int num: nums) {
            if (votes == 0) res = num;
            votes += num == res ? 1 : -1;
        }
        // 如果不确定有没有，在来一趟检验
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) cnt++;
        }
        return cnt > nums.length >> 2 ? res : 0;
    }


}
