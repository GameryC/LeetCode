package jian_zhi_offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/7 10:43
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * 面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
/*
回溯法
 */
public class _34_path_sum {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        backTrace(root, sum);
        return res;
    }

    private void backTrace(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        // target 后来不用恢复，因为target是每个栈帧里的东西，没有在层之间传递。调用结束后就弹出了。
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 结果添加的是新的ArrayList，不然会影响结果
            res.add(new ArrayList<>(path));
        }
        backTrace(root.left, target);
        backTrace(root.right, target);
        path.remove(path.size() - 1);
    }
}
