package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {
    public List<String> findSubsets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        subSet(array, 0, sb, result);
        return result;
    }
    private void subSet(char[] array, int index, StringBuilder sb, List<String> result) {
        //base case
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }

        //branch 1: not add current index element
        subSet(array, index + 1, sb, result);

        //branch 2: add current index element
        sb.append(array[index]);
        subSet(array, index + 1, sb, result);
        // reset to previous state before back-tracking to previous level
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] args) {
        AllSubset test = new AllSubset();
        String s = "";
        List<String> result = test.findSubsets(s);
        System.out.println(result);
    }
}
