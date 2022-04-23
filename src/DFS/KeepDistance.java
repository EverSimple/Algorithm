package DFS;

public class KeepDistance {
    public int[] keepDistance(int k) {
        int[] array = new int[2 * k];
        if (dfs(k, array)) {
            return array;
        } else {
            return null;
        }
    }
    private boolean dfs(int k, int[] array) {
        if (k == 0) { // base case
            return true;
        }
        for (int i = 0; i < array.length - k - 1; i++) {
            if(array[i] == 0 && array[i + k + 1] == 0) { // both spots are empty
                array[i] = k;
                array[i + k + 1] = k;
                if (dfs(k - 1, array)) { // if find one solution,
                    return true; // can stop searching and return
                }
                array[i] = 0;
                array[i + k + 1] = 0;
            }
        }
        return false;
    }
    public static void printArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    public static void main(String[] args) {
        KeepDistance test = new KeepDistance();
        int[] a = test.keepDistance(8);
        printArray(a);
    }

}
