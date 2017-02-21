class NumArray {
    private int[] numsTree;
    private int numsLength;

    private void bulidTree(int[] nums) {
        for (int i = numsLength, j = 0; i < numsLength * 2; i++, j++) {
            numsTree[i] = nums[j];
        }
        for (int i = numsLength - 1; i > 0; i--) {
            numsTree[i] = numsTree[2 * i] + numsTree[2 * i + 1];
        }

    }

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;
        numsLength = nums.length;
        numsTree = new int[numsLength * 2];
        bulidTree(nums);
    }

    public void update(int i, int val) {
        i = numsLength + i;
        numsTree[i] = val;
        while (i > 0) {
            int left = i;
            int right = i;
            if (i % 2 == 0) {
                right++;
            }
            else {
                left--;
            }
            numsTree[i / 2] = numsTree[left] + numsTree[right];
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        i += numsLength;
        j += numsLength;
        int sum = 0;
        while (i <= j) {
            if (i % 2 == 1) {
                sum += numsTree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += numsTree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}