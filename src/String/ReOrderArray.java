package String;

import java.util.Arrays;

public class ReOrderArray {
    public int[] reOrder(int[] array) {
        if (array == null || array.length <= 3) {
            return array;
        }
        //if length is odd, leave the rightmost element at its place
        //so the reorder segment is from 0 to length - 1
        int right = array.length % 2 == 0 ? array.length - 1 : array.length - 2;
        reorder(array, 0, right);
        return array;
    }
    private void reorder(int[] array, int left, int right) {
        int size = right - left + 1;
        // base case
        if (size <= 2) {
            return;
        }
        // step 1: divide into 4 segments
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;
        // step 2: reverse segments 2 and 3
        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);
        // step 3: recursively reorder s1 + s3 and s2 + s4
        reorder(array, left, left + 2 * (leftMid - left) - 1);
        reorder(array,  left + 2 * (leftMid - left), right);
    }
    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }

    /**
    public String reOrder(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // if string length is odd, leave the last char in its place and reorder first (n-1) char
        int right = array.length % 2 == 0 ? array.length - 1 : array.length - 2;
        reorder(array, 0, right);
        return new String(array);
    }
    private void reorder(char[] a, int left, int right) {
        // base case: one or two elements
        if (left >= right - 1) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;
        reverse(a, leftMid, mid -1);
        reverse(a, mid, rightMid - 1);
        reverse(a, leftMid, rightMid - 1);
        reorder(a, left, left + 2 * (leftMid  - left) - 1);
        reorder(a, left + 2 * (leftMid - left), right);
    }
    private void reverse(char[] a, int left, int right) {
        while (left < right) {
            char tmp = a[left];
            a[left++] = a[right];
            a[right--] = tmp;
        }
    }
*/
    public static void main(String[] args) {
        ReOrderArray test = new ReOrderArray();
        String a = "abcde12345";
        int[] array = {1, 2, 3 ,4 , 5, 6};
        System.out.println(Arrays.toString(test.reOrder(array)));
    }
}
