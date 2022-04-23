package DP;

public class LargestRectangleOnes {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) { // corner case
            return 0;
        }
        int m = matrix.length; // num of rows
        int n = matrix[0].length; // num of cols
        int[][] length = longest(matrix, m, n);
        int max = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxLen = length[i][j];
                for (int l = maxLen; l > 0; l--) { //for each length, check width
                    int width = 1;
                    for (int row = i + 1; row < m; row++) {
                        width = row - i + 1;
                        if (length[row][j] < l) {
                            width = row - i;
                            break;
                        }
                    }
                    max = Math.max(max, getArea(l, width));
                }
            }
        }
        return max;
    }
    //
    private int getArea(int length, int width) {
        return length * width;
    }
    private int[][] longest(int[][] matrix, int m, int n) {
        int[][] M = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    M[i][j] = M[i][j + 1] + 1;
                }
            }
        }
        printMatrix(M, m, n);
        return M;
    }

    public void printMatrix(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LargestRectangleOnes test = new LargestRectangleOnes();
        int[][] matrix = new int[][]
        {{1,0,0,1,1,0,1,1}};
        test.printMatrix(matrix);
        System.out.println(test.largest(matrix));
    }
}
