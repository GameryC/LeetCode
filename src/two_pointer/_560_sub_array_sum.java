package two_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/15 9:07
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class _560_sub_array_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        _560_sub_array_sum solution = new _560_sub_array_sum();
        System.out.println(solution.subarraySum3(nums, 2));
    }


    // 1. 暴力, 枚举左边界，右边界找到头 o(n^2),超时
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    cnt++;
                    System.out.println("left: " + left + " right: " + right);
                }
            }
        }
        return cnt;
    }

    // 2.前缀和，preSum[i] 表示包含前i 个元素的前缀和。o(n2)
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            // 计算前缀和的时候，这是个坑！
            // preSum[i + 1] += nums[i]; 不对！！
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (preSum[right + 1] - preSum[left] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 3. 用map，时o(n),空o(n)
    public int subarraySum3(int[] nums, int k) {
        // key 是前缀和，value 是出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 先添加前缀和为0，出现次数为1， 防止当前和已经够了
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }


}
