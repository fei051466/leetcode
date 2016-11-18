public class Solution {
    public void sortColors(int[] nums) {
        int slow = 0;
        int fast = nums.length-1;
        int mid;
        for(mid=slow; mid<nums.length && mid <= fast;){
            if(nums[mid] == 0){
                int temp = nums[slow];
                nums[slow] = 0;
                nums[mid] = temp;
                slow++;
                if(temp == 0) mid++;
            }
            else if(nums[mid] == 2){
                int temp = nums[fast];
                nums[fast] = 2;
                nums[mid] = temp;
                fast--;
            }
            else{
                mid++;
            }
        }
    }
}