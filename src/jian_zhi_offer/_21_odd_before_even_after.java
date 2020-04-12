package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/12 15:59
 */
public class _21_odd_before_even_after {
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
                swap(nums, -- right, i);
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
