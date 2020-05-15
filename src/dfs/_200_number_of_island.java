package dfs;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/28 17:37
 * https://leetcode-cn.com/problems/number-of-islands/
 * 遍历数组，找到岛计数+1，然后dfs,标记此次能到的岛。
 */
public class _200_number_of_island {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }

            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i , j + 1);
        dfs(grid, i , j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }


    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
        };
        _200_number_of_island solution = new _200_number_of_island();
        System.out.println(solution.numIslands(grid));
    }
}
