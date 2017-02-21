public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] maxK = new int[k];
        for (int i = 0; i < k; i++) {
            maxK[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (nums[i] > maxK[j]) {
                    for (int p = k - 1; p > j; p--) {
                        maxK[p] = maxK[p - 1];
                    }
                    maxK[j] = nums[i];
                    break;
                }
            }
        }
        return maxK[k - 1];
    }
}