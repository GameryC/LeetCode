package jian_zhi_offer;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/6 12:29
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 面试题33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 *
 * 提示：
 *
 * 数组长度 <= 1000
 */
public class _33_verify_postorder {

    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] postorder, int start, int end) {
        // 递归记得写 结束条件！！
        if (start >= end) return true;
        int i = start;
        while (postorder[i] < postorder[end]) i++;
        int m = i;
        while (postorder[i] > postorder[end]) i++;
        // 最后一个 end - 1；排除掉最后一个根节点的树
        return i == end && check(postorder, start, m - 1) && check(postorder, m, end - 1);
    }
}
