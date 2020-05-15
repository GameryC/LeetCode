package binary_search;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/27 12:14
 */
public class _81_find_minimum_in_rotated_sorted_array_ii {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            //中点在左半段,这个等于号，因为有不重复，等的时候不能判断在哪边
            //这里比较对象不应该是0位置，应该是左边left 位置
//            if (nums[mid] == nums[0]) {
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] > nums[0]) {
                //左半端，左部分是单调区间
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {// 中点进入右半段，右部分是单调区间
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _81_find_minimum_in_rotated_sorted_array_ii solution = new _81_find_minimum_in_rotated_sorted_array_ii();
        int[] arr = new int[]{2,5,6,0,0,1,2};
        int[] arr2 = new int[]{1,3,1,1,1};
        System.out.println(solution.search(arr2, 3));
    }
}
