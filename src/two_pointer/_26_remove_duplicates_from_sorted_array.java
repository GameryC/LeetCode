package two_pointer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/4 11:07
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class _26_remove_duplicates_from_sorted_array {
    //大雪菜做法：k是要放数的位置，j 去找与上个位置j-1不同的数，然后放到k位置。
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[k++] = nums[j];
            }
        }
        return k;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                //++i 才对，不是i++！！
//                nums[i++] = nums[j];
                //不要用i++了，用[i+1],后来再赋值i++ 好了。
                nums[++i] = nums[j];
            }
            j++;
        }
// 臃肿！！
//        while (j < nums.length) {
//            if (nums[i] == nums[j]) {
//                while (nums[i] == nums[j]) j++;
//                nums[++i] = nums[j];
//            } else {
//                i++;
//                j++;
//            }
//
//        }
        return i + 1;
    }

}
