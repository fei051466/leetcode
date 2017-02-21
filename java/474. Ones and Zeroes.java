public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str: strs) {
            int zeroCount = 0;
            int oneCount = 0;
            char[] strArray = str.toCharArray();
            for (char ch: strArray) {
                if (ch == '0')
                    zeroCount++;
                else
                    oneCount++;
            }
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}