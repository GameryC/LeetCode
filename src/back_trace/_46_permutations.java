package back_trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/25 22:16
 */
public class _46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len == 0) return res;
        List<Integer> path = new ArrayList<>();
        boolean used[] = new boolean[len];
        dfs(nums, 0, len, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int depth, int length, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
//            res.add(path);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, depth + 1, length, path, res, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        _46_permutations solution = new _46_permutations();
        System.out.println((solution.permute(new int[]{1,2,3})));
    }
}
