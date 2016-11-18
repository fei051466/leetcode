public class Solution {
    public boolean canJump(int[] nums) {
        int length = 1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] >= length)
                length = 1;
            else
                length++;
        }
        if(length == 1)
            return true;
        else
            return false;

    }

}