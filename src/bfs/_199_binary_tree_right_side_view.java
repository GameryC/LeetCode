package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/22 17:56
 */
public class _199_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                if (i == size - 1) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.addLast(tmp.right);
                }
            }

        }
        return res;
    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(res, root.right, depth);
        dfs(res, root.left, depth);
    }
}
