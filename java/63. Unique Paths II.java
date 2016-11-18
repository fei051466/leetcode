public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int line = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[line][column];

        for (int i=0; i<line; i++) {
            for (int j=0; j<column; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1- obstacleGrid[0][0];
                else if (obstacleGrid[i][j] == 0) {
                    if (i == 0)
                        dp[i][j] = dp[i][j-1];
                    else if (j == 0)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
                else
                    dp[i][j] = 0;
            }
        }
        return dp[line-1][column-1];
    }
}