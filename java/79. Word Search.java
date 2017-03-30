public class Solution {
    private boolean[][] used;

    private boolean dfs(char[][] board, char[] wordArray, int i, int j, int wordIndex) {
        if (wordArray[wordIndex] != board[i][j])
            return false;
        if (wordIndex == wordArray.length - 1)
            return true;
        used[i][j] = true;
        if (i > 0 && !used[i - 1][j] && dfs(board, wordArray, i - 1, j, wordIndex + 1))
            return true;
        if (j > 0 && !used[i][j - 1] && dfs(board, wordArray, i, j - 1, wordIndex + 1))
            return true;
        if (i < board.length - 1 && !used[i + 1][j] && dfs(board, wordArray, i + 1, j, wordIndex + 1))
            return true;
        if (j < board[0].length - 1 && ! used[i][j + 1] && dfs(board, wordArray, i, j + 1, wordIndex + 1))
            return true;
        used[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        char[] wordArray = word.toCharArray();
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, wordArray, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}