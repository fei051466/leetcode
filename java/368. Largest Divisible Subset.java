public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        int[] dp = new int[nums.length];
        int[] last = new int[nums.length];
        Arrays.sort(nums);
        dp[0] = 1;
        Arrays.fill(last, -1);
        int maxSize = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > max) {
                        max = dp[j] + 1;
                        last[i] = j;
                    }
                }
            }
            dp[i] = max;
            maxSize = Math.max(maxSize, dp[i]);
        }
        int maxIndex;
        for (maxIndex = 0; maxIndex < dp.length; maxIndex++) {
            if (dp[maxIndex] == maxSize)
                break;
        }
        
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = last[maxIndex];
        }
        return result;
    }
}