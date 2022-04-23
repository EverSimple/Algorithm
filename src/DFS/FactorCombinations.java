package DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        List<Integer> sol = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        dfs(0, factors, target, sol, result);
        return result;
    }

    private void dfs(int index, List<Integer> factors, int rem, List<Integer> sol, List<List<Integer>> result) {
        if (index == factors.size()) { //base case
            if (rem == 1) {
                result.add(new ArrayList(sol)); // add cur sol to result
            }
            return; // whether or not finding a solution
        }

// branch 0: not adding cur factor, always go
        dfs(index + 1, factors, rem, sol, result);

// branch 1, 2, …, k
        int factor = factors.get(index);
        int size = sol.size(); // num of cur factor to add at cur level
        while (rem % factor == 0) {
            rem /= factor;
            sol.add(factor);
            dfs(index + 1, factors, rem, sol, result);
        }
// restore to previous level status before backtracking
// can do it once for all after the cur level
       sol.subList(size, sol.size()).clear(); // remove elements in [size, sol.size())
       // sol = sol.subList(0, size);
    }

    private List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = num / 2; i > 1; i--) { // from num/2 to 2, 除尽的就是factor
            if (num % i == 0) {             // 从大到小，dfs时候剪枝快
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        FactorCombinations test = new FactorCombinations();
        System.out.println(test.combinations(12));
    }
}
