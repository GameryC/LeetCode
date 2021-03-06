package two_pointer;

import java.util.Arrays;

/**
 * @author yangchen
 * @date 2020/4/3 9:01 - 9.12 //11min - 9.24 13min 优化
 * 88.
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
// 从尾往前 复制，因为要在arr1里存结果，从头开始可能覆盖arr1 的值。
public class _88_merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] < nums2[index2]) {
                nums1[indexMerge--] = nums2[index2--];
            } else {
//                nums1[indexMerge--] = nums1[index1];//错误！！没有index--!!!
                nums1[indexMerge--] = nums1[index1];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[indexMerge--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
        }
        //nums1 全过来了，nums2剩下的全放开头！！
        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }

    // 大雪菜做法：
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >=0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
