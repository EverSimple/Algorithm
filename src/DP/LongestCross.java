package DP;

public class LongestCross {
    public int largest(int[][] matrix) {
        int m = matrix.length; // num of rows
        if (m == 0) { // corner case
            return 0;
        }
        int n = matrix[0].length; // num of columns
        if (n == 0) { // corner case
            return 0;
        }
        // step 1: get longest consecutive ones for each cell from 4 directions
        int[][] M1 = leftToRight(matrix, m, n); // left to right
        int[][] M2 = rightToLeft(matrix, m, n); // right to left
        int[][] M3 = topToBottom(matrix, m, n); // top to bottom
        int[][] M4 = bottomToTop(matrix, m, n); // bottom to top
        // Step 2:
        int largest = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                int cur = Math.min(Math.min(M1[i][j], M2[i][j]), Math.min(M3[i][j], M4[i][j]));
                largest = Math.max(cur, largest);
            }
        }
        return largest;
    }
    private int[][] leftToRight(int[][] matrix, int m, int n) {
        int[][] M = new int[m][n];
        for (int i = 0; i < m; i++) {
            M[i][0] = matrix[i][0]; // base case 第一列
            for (int j = 1; j < n; j++) { // 正左方 + 1
                M[i][j] = matrix[i][j] == 0 ? 0 : M[i][j - 1] + 1;
            }
        }
        return M;
    }
    private int[][] rightToLeft(int[][] matrix, int m, int n) {
        int[][] M = new int[m][n];
        for (int i = 0; i < m; i++) {
            M[i][n - 1] = matrix[i][n - 1]; // base case 最后一列
            for (int j = n - 2; j >= 0; j--) { // 正右方 + 1
                M[i][j] = matrix[i][j] == 0 ? 0 : M[i][j + 1] + 1;
            }
        }
        return M;
    }
    private int[][] topToBottom(int[][] matrix, int m, int n) {
        int[][] M = new int[m][n];
        for (int j = 0; j < n; j++) {
            M[0][j] = matrix[0][j]; // base case 第一行
            for (int i = 1; i < m; i++) {// 正上方 + 1
                M[i][j] = matrix[i][j] == 0 ? 0 : M[i - 1][j] + 1;
            }
        }
        return M;
    }
    private int[][] bottomToTop(int[][] matrix, int m, int n) {
        int[][] M = new int[m][n];
        for (int j = 0; j < n; j++) {
            M[m - 1][j] = matrix[m - 1][j]; // base case 最后一行
            for (int i = m - 2; i >= 0; i--) {// 正下方 + 1
                M[i][j] = matrix[i][j] == 0 ? 0 : M[i + 1][j] + 1;
            }
        }
        return M;
    }


    public static void main(String[] args) {
        LongestCross test = new LongestCross();
        int[][] A = { {0, 0, 0, 0},
                      {1, 1, 1, 1},
                      {0, 1, 1, 1},
                      {1, 0, 1, 1} };
        System.out.println(test.largest(A));
    }
}
