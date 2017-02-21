public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int subTarget = target - nums[i] - nums[j];
                int x = j + 1;
                int y = nums.length - 1;
                while (x < y) {
                    if (x != j + 1 && nums[x] == nums[x - 1])
                        x++;
                    else if (y != nums.length - 1 && nums[y] == nums[y + 1])
                        y--;
                    else if (nums[x] + nums[y] < subTarget)
                        x++;
                    else if (nums[x] + nums[y] > subTarget)
                        y--;
                    else {
                        List<Integer> valid = new ArrayList<Integer>();
                        valid.add(nums[i]);
                        valid.add(nums[j]);
                        valid.add(nums[x]);
                        valid.add(nums[y]);
                        result.add(valid);
                        x++;
                    }
                }
            }
        }
        return result;
    }
}