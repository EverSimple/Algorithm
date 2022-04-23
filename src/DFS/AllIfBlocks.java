package DFS;

public class AllIfBlocks {
    public void validIfBlocks(int n) {
        char[] sol = new char[2 * n];
        int[] count = new int[1];
        DFS(sol, 0, n, n, count);
        System.out.println("Total number of solution is " + count[0]);
    }
    // index is the level of recursion
    private void DFS(char[] sol, int index, int remLeft, int remRight, int[] count) {
        if (remLeft == 0 && remRight == 0) { // base case
            printBlock(sol); // print solution
            count[0]++;
            return;
        }
        // branch 1: add left brackets if there is any
        if (remLeft > 0) {
            sol[index] = '{';
            DFS(sol, index + 1, remLeft - 1, remRight, count);
        }
        // branch 2: add right brackets when addedLeft > addedRight
        if (remRight > remLeft) {
            sol[index] = '}';
            DFS(sol, index + 1, remLeft, remRight - 1, count);
        }
    }
    private void printBlock(char[] sol) {
        int spaces = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] == '{') {
                printSpaces(spaces);
                System.out.println("if {");
                spaces += 2;
            } else {
                spaces -= 2;
                printSpaces(spaces);
                System.out.println("}");
            }
        }
        System.out.println();
    }
    private void printSpaces(int num) {
        System.out.print(" ".repeat(num));
    }

    public static void main(String[] args) {
        AllIfBlocks test = new AllIfBlocks();
        test.validIfBlocks(6);

    }

}
