package dfs;

/**
 * @descrip:
 * @author: GameryC
 * @date: 2020/4/28 18:18
 * https://leetcode-cn.com/problems/word-search/solution/
 * 找到一个打头的字母，从他开始dfs。找到即为true
 */
public class _79_word_search {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (!inBoard(board, i, j) || visited[i][j] || word.charAt(index) != board[i][j]) return false;
        if (index == word.length() - 1 && word.charAt(index) == board[i][j]) return true;
        visited[i][j] = true;
        int[][] direct = new int[][] {{1,0}, {1,-1},{0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int newX = i + direct[i][0];
            int newY = j + direct[j][1];
            if (dfs(board, newX, newY, word, index, visited)) return true;
        }
        visited[i][j] = false;
        return false;
//        return dfs(board, i + 1, j, word, index, visited)
//        || (dfs(board, i, j + 1, word, 0, visited))
//        || (dfs(board, i - 1, j, word, 0, visited))
//        || (dfs(board, i, j - 1, word, 0, visited));
    }

    private boolean inBoard(char[][] board, int i, int j) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
    }
}
