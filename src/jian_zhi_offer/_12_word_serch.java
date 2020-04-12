package jian_zhi_offer;

/**
 * @author yangchen
 * @date 2020/4/6 18:29
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */
public class _12_word_serch {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int row, int col, int depth) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || words[depth] != board[row][col])
            return false;

        // depth 怎么定啊？？
        // depth就是比较的索引，索引到最后一个，就是结束！！不要一直用0！！
        if (depth == words.length - 1) return true;
        char tmp = board[row][col];
        board[row][col] = '/';
        boolean res = dfs(board, words, row + 1, col, depth + 1) ||dfs(board, words, row - 1, col, depth + 1)
                || dfs(board, words, row, col + 1, depth + 1) || dfs(board, words, row, col - 1, depth + 1);
        board[row][col] = tmp;
        return res;
    }

    public static void main(String[] args) {
        _12_word_serch solution = new _12_word_serch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String str = "ABCCED";
        solution.exist(board, str);
    }
}
