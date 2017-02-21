public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int tmpMin = nums[0];
        
        int i = 1;
        if (nums[i] < nums[i - 1])
        {
            tmpMin = nums[i];
            i++;
        }
        
        for (; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max)
                return true;
            else if (nums[i] < nums[i - 1]) {
                min = tmpMin;
                if (nums[i] > min)
                    return true;
                tmpMin = nums[i];
                max = Math.max(max, nums[i - 1]);
            }
        }
        return false;
    }
}