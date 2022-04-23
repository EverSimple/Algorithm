package String;

public class CompressStr {
    public String compress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }
    private String encode(char[] array) {
        //step 1
        int singleCount = 0;
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int cur = fast;
            while (fast < array.length && array[fast] == array[cur]) {
                fast++;
            }
            array[slow++] = array[cur];
            if (fast - cur == 1) {
                singleCount++;
            } else {
                slow = digitConvert(array, slow, fast - cur);
            }
        }
        int newLen = slow + singleCount;
        if (newLen > array.length) {
            char[] result = new char[newLen];
            singleCompress(array, result, slow - 1, newLen - 1);
            return new String(result);
        } else {
            singleCompress(array, array, slow - 1, array.length - 1);
            return new String(array, array.length - newLen, newLen);
        }
    }
    // put the count num into char array, return the index of slow pointer
    private int digitConvert(char[] array, int slow, int count) {
        int digitCount = 0;
        // get the num of digits in count number to get the beginning index to put digits
        // because the digits we get will be backwards (e.g., count = 123 --> 3, 2, 1)
        for (int i = count; i > 0; i = i / 10) {
            digitCount++;
            slow++;
        }
        // put the digits into char array
        for (int i = count; i > 0; i /= 10) {
            array[--slow] = (char) (i % 10 + '0');
        }
        return slow + digitCount; // slow moved digitCount positions
    }

    private void singleCompress(char[] input, char[] result, int fast, int slow) {
        while (fast >= 0) {
            //case 1: if digit, copy the number to result
            if (Character.isDigit(input[fast])) {
                while (Character.isDigit(input[fast])) {
                    result[slow--] = input[fast--];
                }
            } else {    // case 2: if not a digit, put ‘1’ to result
                result[slow--] = '1';
            }
            // then add the character
            result[slow--] = input[fast--];
        }
    }


    public static void main(String[] args) {
        CompressStr test = new CompressStr();
        System.out.println(test.compress("hhhhhhhhhhhhhhhhhhhhhxxxxxxxxxxxxxxaaaaaaaaaddddffffooooooooooooll"));
    }
}
