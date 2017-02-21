public class Solution {

    private int[] next;
    HashMap<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();

    public Solution(int[] nums) {
        next = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numIndex.put(nums[i], i);
            if (numCount.containsKey(nums[i])) {
                numCount.put(nums[i], numCount.get(nums[i]) + 1);
            }
            else {
                numCount.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            next[i] = numIndex.get(nums[i]);
            numIndex.put(nums[i], i);
        }
    }

    public int pick(int target) {
        int index = numIndex.get(target);
        int nextCount = (int)(Math.random() * numCount.get(target));
        for (int i = 0; i < nextCount; i++) {
            index = next[index];
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */