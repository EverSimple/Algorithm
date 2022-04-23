package DFS;

import java.util.Arrays;

public class RoundTable {
    public boolean canSit(String[] names) {
        return dfs(names, 0);
    }
    private boolean dfs(String[] names, int index) {
        if (index == names.length) { // base case
            return valid(names[index - 1], names[0]);
        }
        for (int i = index; i < names.length; i++) {
            if (index == 0 || valid(names[index - 1], names[i])) {
                swap(names, index, i);
                if (dfs(names, index + 1)) { // if find one solution, return true
                    return true;
                }
                swap(names, index, i);
            }
        }
        return false;
    }
    private boolean valid(String s1, String s2) {
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }
    private void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        RoundTable test = new RoundTable();
        String[] arr = {"ALICE", "CHARLES", "ERICA", "SOPHIA"};
        System.out.println(test.canSit(arr));
    }

    public static class Queens {
        public void nQueens(int n) {
            int[] sol = new int[n];
            nQueens(0, n, sol);
        }
        private void nQueens(int row, int n, int[] sol) {
            // base case
            if(row == n) {
                System.out.println(Arrays.toString(sol));
                return;
            }
            // Branch: for the current row, n possible places(columns) to put queen
            // (row, sol[row]) is the position in the n*n matrix
            for(int i = 0; i < n; i++) {
                sol[row] = i;
                if (valid(sol, row, i)) {
                    nQueens(row + 1, n, sol);
                }
            }
        }
        private boolean valid(int[] sol, int row, int col) {
            for(int i = 0; i < row; i++) {
                if (col == sol[i] || col + row == sol[i] + i || col - row == sol[i] - i) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Queens test = new Queens();
            test.nQueens(5);
        }
    }
}
