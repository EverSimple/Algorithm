package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParenthesesII {
    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        char[] sol = new char[2 * (l + m + n)]; // length is not necessary 6!!!
        int[] count = new int[]{l, l, m, m, n, n};
        char[] p = new char[]{'(', ')', '<', '>', '{', '}'};
        Deque<Character> stack = new ArrayDeque<>();
        dfs(0, p, count, stack, sol, result);
        return result;
    }
    private void dfs(int index, char[] p, int[] count, Deque<Character> stack, char[] sol, List<String> result ) {
        if (index == sol.length) { // base case
            result.add(new String(sol));
            return;
        }
        // 6 branches: which to put ( ) < > { }
        for (int i = 0; i < p.length; i++) {
            if (i % 2 == 0) { // left parentheses (, <, {
                if (count[i] > 0) { // if there is any, can add
                    sol[index] = p[i];
                    stack.offerFirst(p[i]);
                    count[i]--;
                    dfs(index + 1, p, count, stack, sol, result);
                    count[i]++;
                    stack.pollFirst();
                }
            } else { // right parentheses
                if (count[i] > 0 && !stack.isEmpty() && stack.peekFirst() == p[i - 1]) { //top match p[i] so it is top() == p[i-1]!! check empty()!!!
                    // if matched, count[i] must be greater than 0, don't need to check
                    sol[index] = p[i];
                    stack.pollFirst();
                    count[i]--;
                    dfs(index + 1, p, count, stack, sol, result);
                    count[i]++;
                    stack.offerFirst(p[i - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        ValidParenthesesII test = new ValidParenthesesII();
        System.out.println(test.validParentheses(1,0,1));
    }

}
