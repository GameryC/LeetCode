package jian_zhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/5/7 12:19
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class _38_permutation {
    ArrayList<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        StringBuilder path = new StringBuilder();
        dfs(arr, path, visited);
        return res.toArray(new String[arr.length]);
    }

    private void dfs(char[] arr, StringBuilder path, boolean[] visited) {
        if (path.length() == arr.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 判断这个很重要！！
           if (!visited[i]) {
               if(i > 0 && arr[i] == arr[i -1] && visited[i - 1]) continue;
               visited[i] = true;
               path.append(arr[i]);
               dfs(arr, path, visited);
               path.deleteCharAt(path.length() - 1);
               visited[i] = false;
           }
        }
    }

    public static void main(String[] args) {
        _38_permutation solution = new _38_permutation();
        String str = "abbc";
        System.out.println(Arrays.toString(solution.permutation(str)));
    }
}
