package DP;

public class MinCutsPalindrome {
    public int minCuts(String input) {
        if (input == null || input.length() == 0) { // corner case
            return 0;
        }
        return minCuts(input, input.length());
    }
    private int minCuts(String input, int n) {
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) {
            cut[i] = -1; // initiate with -1(cannot partition a palindrome)
            if (isPalindrome(input, 0, i)) {
                cut[i] = 0;
            } else {
                for (int j = i - 1; j > 0; j--) {
                    if (cut[j] >= 0 && isPalindrome(input, j, i)) {
                        cut[i] = cut[i] == -1 ? cut[j] + 1 : Math.min(cut[j] + 1, cut[i]);
                    }
                }
            }
        }
        return cut[n - 1];
    }
    // if substring index range [left, right] is  a palindrome
    private boolean isPalindrome(String input, int left, int right) {
        while (left < right) {
            if(input.charAt(left++) != input.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinCutsPalindrome test = new MinCutsPalindrome();
        System.out.println(test.minCuts("aaab"));
    }
}
