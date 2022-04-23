package String;

public class DecompressStr {
    public String decompress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // Step 1: iterate string to decode any letter of count <= 2
        // also calculate the len of the decoded array
        int newLen = 0;
        int slow = 0; // right border of all the characters to keep (not including slow)
        for (int i = 0; i < array.length; i += 2) {
            int digit = getDigit(array[i + 1]);
            newLen += digit;
            if (digit >= 0 && digit <= 2) {
                while (digit-- > 0) {
                    array[slow++] = array[i];
                }
            } else {
                array[slow++] = array[i];
                array[slow++] = array[i + 1];
            }
        }
        if (newLen > array.length) {
            char[] newArray = new char[newLen];
            return decodeLong(newArray, array, slow - 1, newLen);
        } else {
            return decodeLong(array, array, slow - 1, newLen);
        }
    }
    private String decodeLong(char[] result, char[] input, int start, int len) {
        int index = len - 1; // put char in result from the end
        while (start >= 0) {
            if (Character.isDigit(input[start])) {
                int digit = getDigit(input[start]);
                while (digit-- > 0) {
                    result[index--] = input[start - 1];
                }
                start -= 2;
            } else {
                result[index--] = input[start--];
            }
        }
        return new String(result, 0, len);
    }
    private int getDigit(char digit) {
        return digit - '0';
    }
    public static void main(String[] args) {
        DecompressStr test = new DecompressStr();
        System.out.println(test.decompress("x2y9i0z2"));
    }
}
