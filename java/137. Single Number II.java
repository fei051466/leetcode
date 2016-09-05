public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0 , two = 0 , three = 0;
        for(int i=0; i<nums.length; i++){
            two = (one & nums[i]) | two;
            one = one ^ nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}