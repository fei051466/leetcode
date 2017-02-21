public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] dp = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                }
                else {
                    dp[j] = dp[j - 1] + nums[j];
                }
                if (dp[j] >= s) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                    }
                    break; 
                }
            }
        }


        return min == Integer.MAX_VALUE? 0: min;
    }
}