public class Solution {
    private boolean dfs(int[] nums, int count, int length, int curLength) {
        if (count == 5)
            return true;
        if (curLength > length) {
            return false;
        }
        if (count > 4) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int tmp = nums[i];
            nums[i] = -1;
            if (curLength + tmp == length) {
                if (dfs(nums, count + 1, length, 0))
                    return true;
            }
            else {
                if (dfs(nums, count, length, curLength + tmp))
                    return true;
            }
            nums[i] = tmp;
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 4 != 0)
            return false;
        Arrays.sort(nums);
        return dfs(nums, 1, sum / 4, 0);
    }
}