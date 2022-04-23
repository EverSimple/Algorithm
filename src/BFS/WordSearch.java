package BFS;

import java.util.*;

public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0
                || words == null) { // corner cases
            return result;
        }
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        words = dict.toArray(new String[0]);
        for (String word : dict) {
            if (isWord(board, word)) { // isWord from 154 below
                result.add(word);
            }
        }
        return result;
    }
    public boolean isWord(char[][] board, String word) {
        int m = board.length; // num of rows
        int n = board[0].length; // num of cols
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) { // O(m*n) dfs
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, visited)) { // O(4^l) for each dfs
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (index == word.length()) { // base case: all letters found
            return true;
        }
// early terminate for invalid
        if (i < 0 || i >= board.length || j < 0|| j >= board[0].length ||
                visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
// traverse all branches
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
