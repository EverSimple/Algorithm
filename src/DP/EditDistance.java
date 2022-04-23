package DP;

public class EditDistance {
    public int editDistance(String s1, String s2) {
        return editDist(s1, 0, s2, 0);
    }
    private int editDist(String s1, int i, String s2, int j) {
        //base case: all char in one string are matched,
        // return the num of char still unmatched in the other string
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        int replace = (s1.charAt(i) == s2.charAt(j) ? 0 : 1) +
                editDist(s1, i + 1, s2, j + 1);
        int delete = 1 + editDist(s1, i + 1, s2, j);
        int insert = 1+ editDist(s1, i, s2, j + 1);
        // return min(replace, delete, insert)
        return Math.min(Math.min(replace, delete), insert);
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        String one = "ab";
        String two = "abcde";
        System.out.println(test.editDistance(one, two));
    }
}
