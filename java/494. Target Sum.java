public class Solution {
    private int sum = 0;

    private void findWays(int[] nums, int s, int index, int curSum) {
        if (index == nums.length) {
            if (curSum == s) {
                sum++;
            }
            return;
        }

        findWays(nums, s, index + 1, curSum + nums[index]);
        findWays(nums, s, index + 1, curSum - nums[index]);
    }
    public int findTargetSumWays(int[] nums, int S) {
        findWays(nums, S, 0, 0);

        return sum;
    }
}