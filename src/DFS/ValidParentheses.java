package DFS;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        char[] sol = new char[2 * n];
        DFS(n, n, 0, sol, result);
        return result;
    }
    // left: num of remaining '('
    // right:  num of remaining ')'
    // index is the current position to be considered
    private void DFS (int left, int right, int index, char[] sol, List<String> result) {
        // base case: no more '(' or ')'
        if (left == 0 && right == 0) {
            result.add(new String(sol));//
            return;
        }
    // branch 1: add left if feasible
        if (left > 0) {
            sol[index] = '(';
            DFS(left - 1, right, index + 1, sol, result);
        }
    // branch 2: add right if feasible
        if (right > left) {
            sol[index] = ')';
            DFS(left, right - 1, index + 1, sol, result);
        }
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        List<String> result = test.validParentheses(3);
        System.out.println(result);
    }
}
