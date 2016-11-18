public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return getMinPayMoney(dp, 1, n);
    }

    private int getMinPayMoney(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i=start; i<=end; i++) {
            // 并不是每次二分然后继续计算右边的序列。例如n=4的情况
            int temp = i + Math.max(getMinPayMoney(dp, start, i-1), getMinPayMoney(dp, i+1, end));
            if (temp < min) min = temp;
        }
        dp[start][end] = min;
        return min;
    }
}