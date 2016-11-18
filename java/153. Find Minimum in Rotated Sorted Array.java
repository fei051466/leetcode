public class Solution {
    public int findMin(int[] nums) {
        int i;
        for(i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                break;
            }
        }
        if(i == nums.length-1){
            return nums[0];
        }
        if(i == nums.length-2){
            return nums[nums.length-1];
        }
        if(nums[i+1] < nums[i+2]){
            return nums[i+1];
        }
        else{
            return nums[i+2];
        }
    }
}