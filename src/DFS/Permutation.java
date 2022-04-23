package DFS;

public class Permutation {
    public void permutation(String a) {
        char[] input = a.toCharArray();
        permutation(input, 0);
    }
    private void permutation(char[] input, int index) {
   // base case & corner case
        if(index == input.length - 1 || index == input.length) {
            System.out.println(input);
            return;
        }
        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            permutation(input, index + 1);
            swap(input, index, i);
        }
    }
    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
    public void permutation(String a) {
        if (a == null) {
            return;
        }
        char[] input = a.toCharArray(); // {a, b, c}
        permutation(input, 0);
    }
    // input [0,index - 1]已经固定的位置
    // input[index, n-1] 尚未确定位置，可以交换的元素
    // index：当前层需要确定的元素的index
    // 当前层：确定input[index]是谁，每层确定一个位置
    private void permutation(char[] input, int index) {
        // 在倒数第二层可以收集解,因为最后一层只能和自己换
        if (index == input.length - 1 || index == input.length) { //if input is [], [] is a solution,
            System.out.println(input);
            return;
        }
        //从index开始（inclusive）的所有元素都是可换的元素
        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            permutation(input, index + 1);
            swap(input, index, i);// 进入下一个分支之前先回到上一层
        }
    }
    private void swap(char[] input, int a, int b) {
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
**/
    public static void main(String[] args) {
        Permutation test = new Permutation();
        String a = "abc";
        test.permutation(a);
    }

}
