public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        System.arraycopy(nums, 0, sums, 0, nums.length);
        for(int index=1; index<nums.length; index++)
            sums[index] += sums[index-1];
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return sums[j];
        else
            return sums[j] - sums[i-1];
    }
}