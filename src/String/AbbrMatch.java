package String;

public class AbbrMatch {
    public boolean match(String input, String pattern) {
        return match(input, 0, pattern, 0);
    }
    private boolean match(String input, int i, String pattern, int j) {
        if (i == input.length() && j == pattern.length()) {
            return true;
        }
        if (i >= input.length() || j >= pattern.length()) {
            return false;
        }
        if (!Character.isDigit(pattern.charAt(j))) { // case 1
            if (input.charAt(i) == pattern.charAt(j)) {
                return match(input, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
        // case 2: pattern.charAt(j) is digit
        int[] num = new int[2];
        getCount(pattern, j, num);
        int letterCount = num[0];
        int digitCount = num[1];
        return match(input, i + letterCount, pattern, j + digitCount);
    }
    private void getCount (String s, int j, int[] num) {
        while (j < s.length() && Character.isDigit(s.charAt(j))) {
            num[1] += 1; // digitCount
            int digit = s.codePointAt(j++) - '0';
            num[0] = num[0] * 10 + digit; // letterCount
        }
    }

    public static void main(String[] args) {
        AbbrMatch test = new AbbrMatch();
        System.out.println(test.match("laioffercom", "6fer3"));
    }
}
