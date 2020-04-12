package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/7 9:24
 * 面试题14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
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
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
public class _14_ii_jian_sheng_zi {
    //注意！！
    //最大值可能超过 int 范围，要用 long 类型！！
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int x = n / 3 - 1;
        int mod = n % 3;
        //这两个变量 都得是long！！
        long res = 1;
        long base = 3;
        int p = 1000000007;
        while (x != 0) {
            if ((x & 1) == 1) {
                res = (res * base) % p;
            }
            base = (base * base) % p;
            x = x >> 1;
        }
        // for (int i = 0; i < x; i++) {
        //     res = res * 3 % p;
        // }
        if (mod == 0) {
            res = res * 3 % p;
        } else if (mod == 1) {
            res = res * 4 % p;
        } else {
            res = res * 6 % p;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        _14_ii_jian_sheng_zi solution = new _14_ii_jian_sheng_zi();
        System.out.println(solution.cuttingRope(6));
    }
}
