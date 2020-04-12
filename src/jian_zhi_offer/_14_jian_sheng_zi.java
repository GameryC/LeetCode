package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/7 9:07 - 9.13
 * 面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
public class _14_jian_sheng_zi {
    // 贪心 尽量分3，
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int x = n / 3;
        int mod = n % 3;
        int res = 0;
        if (mod == 0) {
            res = (int) Math.pow(3, x);
        } else if (mod == 1) {
            res = (int) Math.pow(3, x-1) * 4;
        } else {
            res = (int) Math.pow(3, x) * 2;
        }
        return res;
    }

}
