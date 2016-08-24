public class Solution {
    private int[] origin;

    public Solution(int[] nums) {
        origin = new int[nums.length];
        for(int index=0; index<nums.length; index++){
            origin[index] = nums[index];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[origin.length];
        for(int index=0; index<origin.length; index++){
            res[index] = origin[index];
        }
        for(int i=res.length; i>0; i--){
            int random_index = (int)(Math.random()*i);
            int temp = res[i-1];
            res[i-1] = res[random_index];
            res[random_index] = temp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */