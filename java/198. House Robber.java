public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        result[1] = nums[0];
        for (int i=1; i<nums.length; i++)
            result[i+1] = Math.max(result[i],  result[i-1] + nums[i]);
        return result[nums.length];
    }
}