package back_trace;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchen
 * @date 2020/4/9 8:49
 */
public class _22_generate_parentheses {
    ArrayList<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, sb, n);
        return res;
    }

    private void dfs(int left, int right, StringBuilder sb, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            dfs(left + 1, right, sb.append("("), n);
            //用 sb 的话，需要还原现场，因为
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            dfs(left, right + 1, sb.append(")"), n);
            sb.deleteCharAt(sb.length() - 1);

        }
    }

    public static void main(String[] args) {
        _22_generate_parentheses solution = new _22_generate_parentheses();
        solution.generateParenthesis(3);
        System.out.println(solution.res);
    }
}
