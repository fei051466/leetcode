public class Solution {
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int max = res[0];
        for(int i=1; i<nums.length; i++){
            res[i] = Math.max(res[i-1]+nums[i], nums[i]);
            if(res[i] > max){
                max = res[i];
            }
        }
        return max;
    }
}