public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int result = nums.length;
        int index_new = 0;
        for(int i=0; i<nums.length; i++)
        {
            if (nums[i] == val)
                result--;
            else
                nums[index_new++] = nums[i];
        }
        return result;
    }
}