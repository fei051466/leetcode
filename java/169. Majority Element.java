public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int flag = 0;
        for (int i=0; i<nums.length; i++)
        {
            if (count == 0)
            {
                flag = nums[i];
                count += 1;
            }
            else
            {
                if (flag == nums[i])
                    count += 1;
                else
                    count -= 1;
            }
        }
        return flag;
    }
}