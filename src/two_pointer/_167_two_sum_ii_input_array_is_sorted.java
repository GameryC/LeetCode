package two_pointer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/4 10:37
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
/*
思路：
开头结尾各一个指针，
和为结果则返回；
和大于结果左边右移，变大一点；
和小于结果右边左移，变小一点；
左右碰头结束。
 */
public class _167_two_sum_ii_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target){
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
