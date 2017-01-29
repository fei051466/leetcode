public class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int right;
        int count;
        for (right = 0; right < 32; right++){
            count = 0;
            for (int i = 0; i < nums.length; i++){
                count += (nums[i] >> right) & 1;
            }
            result += count * (nums.length - count);
        }
        return result;
    }
}