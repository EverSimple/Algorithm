package DFS;

import java.util.ArrayList;
import java.util.List;

public class CoinsComb {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0) {
            return result;
        }
        List<Integer> sol = new ArrayList<>();
        helper(coins, 0, target, sol, result);
        return result;
    }
    // index: current coin to be considered
    // branch: how many of this value coin to use
    private void helper(int[] coins, int index, int moneyLeft, List<Integer> sol, List<List<Integer>> result) {
        // base case: coins all considered, return
        // if NO moneyLeft, add to result before return
        if(index == coins.length - 1) {
            if(moneyLeft % coins[index] == 0) {
                sol.add(moneyLeft / coins[index]);
                result.add(new ArrayList<Integer>(sol));//！！！要NEW一个obj出来
                sol.remove(sol.size() - 1);
            }
            return;
        }
        //number of branch depends on the max num of coins can take
        int max = moneyLeft / coins[index];
        for (int i = 0; i <= max; i++) {
            sol.add(i);
            helper(coins, index + 1, moneyLeft - coins[index] * i, sol, result);
            sol.remove(sol.size() - 1);
        }
    }
    public static void main(String[] args) {
        CoinsComb test = new CoinsComb();
        int[] coins = new int[] {25, 10, 5, 2};
        List<List<Integer>> result = test.combinations(99, coins);
        for(List l : result) {
            System.out.println(l);
        }
    }
}
