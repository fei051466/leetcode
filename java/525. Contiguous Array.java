public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int pre = i - dp[i - 1] - 1;
            if (pre >= 0 && nums[i] + nums[pre] == 1) {
                if (pre == 0)
                    dp[i] = dp[i - 1] + 2;
                else
                    dp[i] = dp[i - 1] + dp[pre - 1] + 2;
            }
            else {
                pre++;
                int count = 1;
                while (pre < i) {
                    if (nums[i] + nums[pre] == 1)
                        count++;
                    else
                        count--;
                    if (count == 0)
                        break;
                    pre++;
                }
                if (pre < i) {
                    dp[i] = i - pre;
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}