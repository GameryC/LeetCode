package jian_zhi_offer;

import tree.TreeNode;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/5 11:20
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 */
/*
先判断
 */
public class _26_is_sub_structure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (!isPartSame(A, B)) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        } else {
            return true;
        }
    }

    private boolean isPartSame(TreeNode A, TreeNode B) {
        // B 打空了，A还有也没关系，B是A的子结构
        if (B == null) return true;
        // B 还有 但是A么有了，B 不是 A的子结构
        if (A == null) return false;
        if (A.val != B.val) return false;
        return isPartSame(A.left, B.left) && isPartSame(A.right, B.right);
    }
}
