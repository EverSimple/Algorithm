package DP;
// Time: O(n) * O(n) * O(1) = O(n^2) --> O(n^1.5)
// Space: O(n)
public class MinBoxes {
    public int packing(int num) {
        int[] M = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            M[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) { // O(n^.5)
                M[i] = Math.min(M[i], M[i - j * j] + 1);
//                if (valid(i - j)) {
//                    M[i] = Math.min(M[i], M[j] + 1);
//                }
            }
        }
        return M[num];
    }
    private boolean valid (int n) {
        int squareRoot = (int) Math.sqrt(n);
        return squareRoot * squareRoot == n;
    }

    public static void main(String[] args) {
        MinBoxes test = new MinBoxes();
        System.out.println(test.packing(15));
    }
}
