public class Solution {
    private boolean dfs(int[] nums, int index, int remain) {
        if (remain == 0) {
            return true;
        }
        if (remain < 0) {
            return false;
        }
        for (int i = index; i >=0; i--) {
            if (i != index && nums[i] == nums[i + 1])
                continue;
            if (dfs(nums, i - 1, remain - nums[i]))
                return true;
        }
        return false;
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, sum);
    }
}