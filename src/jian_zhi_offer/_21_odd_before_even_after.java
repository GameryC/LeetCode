package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/12 15:59
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class _21_odd_before_even_after {

    // 类似快排,双百做法
    public int[] exchange3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <right) {
            while (left < nums.length && (nums[left] & 1) == 1) left++;
            while (right > 0 && (nums[right] & 1) == 0) right--;
            if (left >= right) break;
            swap(nums, left, right);
        }
        return nums;
    }


//    2020.4.2
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            //奇数放前边，是奇数就过，找偶数 换
            while (left < right && (nums[left] & 1) == 1) left++;

            //偶数放后边，是偶数就过，找奇数 换
            while (left < right && (nums[right] & 1) == 0) right--;
            swap(nums, left, right);

        }
        return nums;
    }



//    2020.4.2
        //每一个都判断交换，不如左找右找然后交换
    public int[] exchange2(int[] nums) {
        if (nums == null) return new int[0];
        int len = nums.length;
        int left = -1;
        int right = len;
        int i = 0;
        // for (int i = 0; i < len; i++) {
        while (i < right) {
            if ((nums[i] & 1) == 1) {
                swap(nums, ++left, i++);
            } else {
                swap(nums, --right, i);
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
