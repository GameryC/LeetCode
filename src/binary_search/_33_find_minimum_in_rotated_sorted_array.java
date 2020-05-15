package binary_search;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/27 11:50
 *
 */
public class _33_find_minimum_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            //中点在左半段,这个等于号，因为全部不重复，等的时候说明是到左边界了。进去判断一下就出结果
            if (nums[mid] >= nums[0]) {
                //这里的 >= 写错了！！
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
        return -1;
    }

    public static void main(String[] args) {
        _33_find_minimum_in_rotated_sorted_array solution = new _33_find_minimum_in_rotated_sorted_array();
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.search(arr, 0));
    }
}
