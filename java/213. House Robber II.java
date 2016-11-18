public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dpFirstRob = new int[nums.length + 1];
        dpFirstRob[0] = 0;
        dpFirstRob[1] = nums[0];
        for(int i=1; i<nums.length - 1; i++) {
            dpFirstRob[i + 1] = Math.max(dpFirstRob[i], dpFirstRob[i-1] + nums[i]);
        }
        dpFirstRob[nums.length] = dpFirstRob[nums.length - 1];
        int[] dpFirstNotRob = new int[nums.length + 1];
        dpFirstNotRob[0] = 0;
        dpFirstNotRob[1] = 0;
        for(int i=1; i<nums.length; i++) {
            dpFirstNotRob[i + 1] = Math.max(dpFirstNotRob[i], dpFirstNotRob[i-1] + nums[i]);
        }
        return Math.max(dpFirstRob[nums.length], dpFirstNotRob[nums.length]);
    }
}