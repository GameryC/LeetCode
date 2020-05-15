package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangchen
 * @date 2020/4/16 16:11 - 16.37
 */
public class _1162_as_far_from_land_as_possible {
    public int maxDistance(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (queue.size() == 0 || queue.size() == row * col) return -1;
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] tmp = null;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < row && newY >=0 && newY < col && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[] {newX, newY});
                    grid[newX][newY] = grid[x][y] + 1;
                }
            }
        }
        // 最后访问的那个点的值 - 1 ，就是距离
        int res = grid[tmp[0]][tmp[1]];
        return res - 1;
    }

}
