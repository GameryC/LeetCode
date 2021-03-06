package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/11 9:59
 * 
 *
 * 因为lowestCommonAncestor(root, p, q)的功能是找出以root为根节点的两个节点p和q的最近公共祖先，所以递归体分三种情况讨论：
 *
 * 如果p和q分别是root的左右节点，那么root就是我们要找的最近公共祖先
 * 如果p和q都是root的左节点，那么返回lowestCommonAncestor(root.left,p,q)
 * 如果p和q都是root的右节点，那么返回lowestCommonAncestor(root.right,p,q)
 * 边界条件讨论：
 *
 * 如果root是null，则说明我们已经找到最底了，返回null表示没找到
 * 如果root与p相等或者与q相等，则返回root
 * 如果左子树没找到，递归函数返回null，证明p和q同在root的右侧，那么最终的公共祖先就是右子树找到的结点
 * 如果右子树没找到，递归函数返回null，证明p和q同在root的左侧，那么最终的公共祖先就是左子树找到的结点
 *  */

public class _68_lowest_common_ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 我的分类写法：
//        if (root == null) return null;
//        if (root == p || root == q) return root;
        // 我的合并写法，12ms
//         if (root == null || root == p || root == q) return root;
        // 答案写法，调换位置，7ms???
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
//        if (left == null) return right;
//        if (right == null) return left;
        return left == null ? right : left;
    }

    //搜索二叉树写法
    public TreeNode lowestCommonAncestors(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestors(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestors(root.right, p, q);
        } else {
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}