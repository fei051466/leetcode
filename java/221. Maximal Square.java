public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][][] dp = new int[matrix.length][matrix[0].length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (j == dp[i].length - 1)
                        dp[i][j][0] = j;
                    else
                        dp[i][j][0] = Math.max(j, dp[i][j + 1][0]);
                }
                else {
                    dp[i][j][0] = -1;
                }

            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (matrix[j][i] == '1') {
                    if (j == dp.length - 1)
                        dp[j][i][1] = j;
                    else
                        dp[j][i][1] = Math.max(j, dp[j + 1][i][1]);
                }
                else {
                    dp[j][i][1] = -1;
                }
            }
        }

        int max = 0;
        int maxLength = Math.min(matrix.length, matrix[0].length);
        boolean[][][] resultDP = new boolean[matrix.length][matrix[0].length][maxLength + 1];
        for (int i = 0; i < resultDP.length; i++) {
            for (int j = 0; j < resultDP[i].length; j++) {
                for (int k = 1; k < resultDP[i][j].length; k++) {
                    if (k == 1)
                        resultDP[i][j][k] = matrix[i][j] == '1';
                    else if ((j + k > resultDP[i].length) || (i + k > resultDP.length))
                        break;
                    else {
                        resultDP[i][j][k] = resultDP[i][j][k - 1] && dp[i][j + k - 1][1] - i + 1 >= k && dp[i + k - 1][j][0] - j + 1>= k;
                    }
                    if (resultDP[i][j][k])
                        max = Math.max(max, k);
                }
            }
        }

        return max * max;
    }
}