package DFS;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {
    public List<String> decode(String input) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(input, 0, sb, result);
        return result;
    }
    private void dfs(String input, int index, StringBuilder sb, List<String> result) {
        if (index == input.length()) {
            result.add(sb.toString());
            return;
        }
        // branch 1: single-digit number
        if (index < input.length()) {
            int num = input.charAt(index) - '0';
            if (num >= 1 && num <= 9) {
                sb.append((char)(num - 1 + 'A')); // 1 → A
                dfs(input, index + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        // branch 2: double-digit number
        if (index + 1 < input.length()) {
            int num = (input.charAt(index) - '0') * 10
                    + (input.charAt(index + 1) - '0');
            if (num >= 10 && num <= 26) {
                sb.append((char)(num - 1 + 'A'));
                dfs(input, index + 2, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        String s = "1234567";
        System.out.println(test.decode(s));
    }
}
