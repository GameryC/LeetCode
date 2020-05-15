package tree;

import java.util.Stack;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 10:11
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
/*
思路：
搜索二叉树，中序遍历得升序排列数组。中序遍历并判断是否升序即可。
有 递归 和非递归 两种算法。
 */
public class _98_validate_binary_search_tree {
    // 递归做法
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!(isValidBST(root.left))) return false;

        if (root.val <= pre) return false;
        pre = root.val;

        return isValidBST(root.right);
    }

    // 非递归做法 树的中序遍历
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 这里要用 long, int的话 -2147483648输出结果false，不是正确结果true；
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

}
