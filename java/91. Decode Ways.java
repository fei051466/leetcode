public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        char[] sArray = s.toCharArray();
        int[] dp = new int[sArray.length + 1];
        dp[dp.length - 1] = 1;
        for (int i = sArray.length - 1; i >= 0; i--) {
            if (sArray[i] == '0')
                dp[i] = 0;
            else if (sArray[i] >= '3')
                dp[i] = dp[i + 1];
            else if (sArray[i] == '1') {
                if (i != sArray.length - 1) {
                    dp[i] = dp[i + 2] + dp[i + 1];
                }
                else {
                    dp[i] = dp[i + 1];
                }
            }
            else if (sArray[i] == '2') {
                if (i != sArray.length - 1 && sArray[i + 1] <= '6') {
                    dp[i] = dp[i + 2] + dp[i + 1];
                }
                else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }
}