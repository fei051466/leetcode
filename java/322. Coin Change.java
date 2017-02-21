public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j])
                    continue;
                if (dp[i - coins[j]] == -1)
                    continue;
                if (min == -1) 
                    min = dp[i - coins[j]] + 1;
                else
                    min = Math.min(min, dp[i - coins[j]] + 1);
            }
            dp[i] = min;
        }

        return dp[amount];
    }
}