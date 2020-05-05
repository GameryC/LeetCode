package jian_zhi_offer;

import java.util.Arrays;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 12:10
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
// 题解
// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/

public class _29_spiral_order {
    public int[] spiralOrder(int[][] matrix) {
        // 这个特判，不然[]报错！！
        if (matrix.length == 0) return new int[0];
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int index = 0;
        int[] res = new int[(r + 1) *(b + 1)];
        while (true) {
            for (int i = l; i <= r; i++)
                res[index++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++)
                res[index++] = matrix[i][r];
            if (l > --r) break;
            for (int i = r; i >= l ; i--)
                res[index++] = matrix[b][i];
            if (t > --b) break;
            for (int i = b; i >= t; i--)
                res[index++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        _29_spiral_order solution = new _29_spiral_order();
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
