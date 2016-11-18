public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int res = 1;
        boolean isTwice = false;
        int newIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!isTwice) {
                    res++;
                    isTwice = true;
                    nums[newIndex++] = nums[i];
                }
            }
            else if (nums[i] != nums[i - 1]) {
                res++;
                isTwice = false;
                nums[newIndex++] = nums[i];
            }
        }
        return res;
    }
}
