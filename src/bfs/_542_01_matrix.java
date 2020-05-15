package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangchen
 * @date 2020/4/16 15:26
 */
public class _542_01_matrix {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int rnum = matrix.length;
        int cnum = matrix[0].length;
        int[][] res = new int[rnum][cnum];
        boolean[][] visited = new boolean[rnum][cnum];
        for (int i = 0; i < rnum; i++) {
            for (int j = 0; j < cnum; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    // 加入的时候一定要修改访问！！
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 此处把 cnum 写错成 rnum !!!挑半天！！！
                if (newX >=0 && newX < rnum && newY >=0 && newY < cnum && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    res[newX][newY] = res[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[1][1] = 1;
//        matrix[2][0] = 1;
//        matrix[2][1] = 1;
//        matrix[2][2] = 1;
        int[][] matrix = new int[4][1];

        printMatrix(matrix);
        _542_01_matrix soluton = new _542_01_matrix();
        int[][] res = soluton.updateMatrix(matrix);
        printMatrix(res);
    }

    public static void printMatrix(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
