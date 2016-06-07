public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> aset = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++)
        {
            aset.add(nums[i]);
        }
        if (aset.size() == nums.length)
            return false;
        else
            return true;
    }
}