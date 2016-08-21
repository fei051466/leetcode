public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int temp;
        int i, j;
        for(i=0, j=nums.length-1-k; i<j; i++, j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for(i=nums.length-k, j=nums.length-1; i<j; i++, j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for(i=0, j=nums.length-1; i<j; i++, j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}